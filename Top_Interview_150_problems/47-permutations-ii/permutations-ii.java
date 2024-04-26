class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // Essential for duplicate handling
        backtrack(nums, results, new ArrayList<>(), new boolean[nums.length]);
        return results;
    }

    private void backtrack(int[] nums, List<List<Integer>> results, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue; // Skip duplicates
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, results, current, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

}