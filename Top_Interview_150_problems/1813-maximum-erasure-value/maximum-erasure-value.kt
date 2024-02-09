class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var maxScore = 0

        val map = HashMap<Int, Int>()
        var currScore = 0
        var left = 0

        for (right in nums.indices) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1)
            currScore += nums[right]

            while(map.containsKey(nums[right]) && map.get(nums[right])!! > 1){
                if (map.containsKey(nums[left])){
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1)
                }
                currScore-= nums[left]
                left++
            }

            maxScore = Math.max(maxScore, currScore)
        }

        return maxScore

    }
}