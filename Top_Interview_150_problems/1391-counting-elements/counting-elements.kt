class Solution {
    fun countElements(arr: IntArray): Int {
        val set = HashSet<Int>()
        
        for (num in arr){
            set.add(num)
        }
        
        var count = 0
        
        for (x in arr){
            if (set.contains(x+1)){
                count += 1
            }
        }
        
        return count
    }
}