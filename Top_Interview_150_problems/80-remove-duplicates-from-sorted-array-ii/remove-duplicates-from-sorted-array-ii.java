class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2 ){
            return nums.length;
        }
        //1,1,1,2,2,4,4,4 -> [1,1,2,2,4]
        int curr = 2;
        //1,1,2,2,2,3
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[curr-2]){
                nums[curr] = nums[i];
                curr++;
            } 
        }
        return curr;
    }
}