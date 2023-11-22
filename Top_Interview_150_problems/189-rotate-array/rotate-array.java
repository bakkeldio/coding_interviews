class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == k){
            return;
        }
        int size = nums.length;
        k = k % size;
        int[] n = new int[size];
        for (int i = 0; i < size; i++){
            if (i < k){
                n[i] = nums[size + i - k];
            } else {
                n[i] = nums[i-k];
            }
        }

        for (int i = 0; i < size; i++){
            nums[i] = n[i];
        }
    
    }
}