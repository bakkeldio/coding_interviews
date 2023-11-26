class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            ans = nums[i-1] * ans;
            answer[i] = ans;
        }

        ans = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            answer[i] = ans * answer[i];
            ans *= nums[i];
        }
        return answer;
    }
}