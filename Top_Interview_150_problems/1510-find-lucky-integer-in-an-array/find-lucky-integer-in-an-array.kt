class Solution {
    fun findLucky(arr: IntArray): Int {
        val map = HashMap<Int, Int>()

        var largest = Int.MIN_VALUE

        for (num in arr){
            map.put(num, map.getOrDefault(num, 0) + 1)
        }

        for (key in map.keys) {
            if (key == map.get(key)!!){
                largest = Math.max(largest, key)
            }
        }
        return if (largest == Int.MIN_VALUE) -1 else largest
    }
}