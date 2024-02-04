class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val strB = StringBuilder(word)

        val end = strB.indexOf(ch)

        if (end == -1){
            return word
        }

        var left = 0

        var right = end

        while(left < right) {
            val lS = strB.get(left)

            strB.set(left, strB.get(right))

            strB.set(right, lS)

            left++
            right--
        }

        return strB.toString()
    }
}