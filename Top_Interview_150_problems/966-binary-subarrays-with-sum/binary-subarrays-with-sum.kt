class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {

        var left = 0
        var count = 0
        var currSum = 0

        val sum = HashMap<Int, Int>()

        for (right in nums.indices){
            sum.put(currSum, sum.getOrDefault(currSum, 0) + 1)
            currSum += nums[right]
            if (sum.containsKey(currSum - goal)){
                count += sum.get(currSum - goal)!!
            }
        }

        return count
    }
}