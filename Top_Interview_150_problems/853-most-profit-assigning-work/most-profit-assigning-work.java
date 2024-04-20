class Solution {

    class Job {
        int difficulty;
        int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.difficulty));

        // Sort workers by ability 
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
         for (int skill: worker) {
            while (i < n && skill >= jobs[i].difficulty)
                best = Math.max(best, jobs[i++].profit);
            ans += best;
        }

        return ans;
    }
}