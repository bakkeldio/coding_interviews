class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        
        val map = hashMapOf<Int, Int>()

        var left = 0

        var ans = 1


        for (i in nums.indices){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1)

            while(map.getOrDefault(nums[i], 0) > k){
                map.put(nums[left], map.get(nums[left])!! - 1)
                left++
            }

            ans = Math.max(ans, i - left + 1)

        }
        return ans


    }
}