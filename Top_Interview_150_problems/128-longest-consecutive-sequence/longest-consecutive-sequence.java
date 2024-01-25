class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int count = 1;
        int maxLength = 0;
        
        for (int num: nums) {
            if (!set.contains(num-1)){
                int x = num;
                count = 1;
                while(set.contains(x+1)){
                    x++;
                    count++;
                }
            }
                    maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}