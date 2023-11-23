class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0;
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] == n-1){
            return 1;
        }
        int i = 0;
        while(i < nums.length){
            jump ++;
            int dis = nums[i]+i;
            if (dis >= n-1){
                break;
            }
            int max = 0;
            int temp = 0;
            for (int j = i + 1; j <= dis; j++) {
                int d = nums[j];
                if(j + d >= max) {
                    max = j + d;
                    temp = j;
                }
            }
            i = temp;
        }
        return jump;
    }
}