class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        
        val map = hashMapOf<Int, Int>()

        var max = 1
        for (num in nums){
            if (map.containsKey(num)){
                val count = map.get(num)!! + 1
                max = Math.max(count, max)
                map.put(num, map.get(num)!! + 1)
            } 
            map.putIfAbsent(num, 1)
        }

        var cnt = 0
        for (value in map.values) {
            if (max == value){
                cnt += 1
            }
        }

        return max * cnt
    }
}