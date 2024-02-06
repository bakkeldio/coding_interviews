class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
                
        map.put(0, -1);

        int maxlen = 0, count = 0;

        
        for (int right = 0; right < nums.length; right++) {

           count = count + (nums[right] == 1 ? 1 : -1);

           if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, right - map.get(count));
            } else {
                map.put(count, right);
            }
            
        }
        
        return maxlen;
        
        
    }
}