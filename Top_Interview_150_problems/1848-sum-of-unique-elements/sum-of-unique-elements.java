class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            map.putIfAbsent(num, 1);
        }

        for (int key: map.keySet()){
            if (map.get(key) == 1){
                sum += key;
            }
        }

        return sum;
    }
}