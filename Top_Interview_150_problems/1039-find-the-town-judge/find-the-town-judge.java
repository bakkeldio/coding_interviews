class Solution {
/** 
    public int findJudge(int n, int[][] trust) {
        int[] total = new int[n + 1];
        
        for (int[] t : trust) {
            total[t[0]]--;
            total[t[1]]++;
        }

        for (int node = 1; node <= n; node++){
            if (total[node] == n - 1){
                return node;
            }
        }
        return -1;
    }
*/
    public int findJudge(int n, int[][] trust) {
        // If the number of people is 1, then the only person is the judge
        if (n == 1) {
            return 1;
        }

        // Create an array to count the trust scores for each person
        int[] trustScores = new int[n + 1];

        // Loop through the trust array and update the trust scores
        for (int[] pair : trust) {
            int trustor = pair[0];
            int trusted = pair[1];

            // Increment the trust score of the trusted person
            trustScores[trusted]++;

            // Decrement the trust score of the trustor, as they trust someone else
            trustScores[trustor]--;
        }

        // Loop through the trust scores to find the person with a trust score of n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        // If no person has a trust score of n - 1, then there is no judge
        return -1;
    }

    
}