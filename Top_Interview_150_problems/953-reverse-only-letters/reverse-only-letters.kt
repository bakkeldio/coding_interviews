class Solution {
    fun reverseOnlyLetters(s: String): String {
        
        val arr = s.toCharArray()

        var left = 0

        var right = arr.size - 1

        while(left < right) {
            
            if (!arr[left].isLetter()) {
                left++;
                continue
            }

            if (!arr[right].isLetter()){
                right--
                continue
            }

            val leftC = arr[left]

            arr[left] = arr[right]

            arr[right] = leftC

            left++
            right--
        }

        return String(arr)


    }
}