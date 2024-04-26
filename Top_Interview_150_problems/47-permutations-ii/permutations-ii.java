class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting helps identify duplicates
        backtrack(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) { 
                continue; // Skip duplicates
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, result, current);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}