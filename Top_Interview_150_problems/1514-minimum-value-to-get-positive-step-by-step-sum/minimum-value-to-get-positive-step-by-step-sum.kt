class Solution {
    fun minStartValue(nums: IntArray): Int {
        

        var minVal = 0

        var total = 0;
        for (i in nums) {
            total += i
            minVal = Math.min(minVal, total)

        }

        return -minVal + 1
    }
}