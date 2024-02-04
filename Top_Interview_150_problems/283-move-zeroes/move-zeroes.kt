class Solution {
    fun moveZeroes(nums: IntArray): Unit {

        var left = 0
        for (i in nums.indices){
            if (nums[i] != 0){
                val n = nums[left]
                nums[left] = nums[i]
                nums[i] = n
                left++
            }
        }
    }
}