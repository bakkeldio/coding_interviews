class Solution {
    public int majorityElement(int[] nums) {
       int times = nums.length / 2;
       Arrays.sort(nums);
       int max = nums[0];
       int count = 1;
       for (int i = 1; i < nums.length; i++) {
           if (nums[i] == nums[i-1]){
                count++;
                max = nums[i];
                if(count > times){
                    return max;
                }
           } else {
              count = 1;
           }
       }
       return max;

    }
}