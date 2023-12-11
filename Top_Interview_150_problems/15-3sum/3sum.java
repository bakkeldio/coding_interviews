class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> list = new HashSet<>();
        
        for (int i = 0; i < nums.length - 2; i++) {

            int low = i + 1;
            int high = nums.length - 1;


            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum == 0){
                
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum > 0){
                    high--;
                } else {
                    low++;
                }
            }
        }
        return new ArrayList<>(list);

    }
}