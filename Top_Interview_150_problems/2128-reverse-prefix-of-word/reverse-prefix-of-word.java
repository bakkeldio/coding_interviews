class Solution {
    public String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == ch){
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i+1));
                sb.reverse(); 
                sb.append(word.substring(i+1, word.length()));
                return sb.toString();
            }
        }
        return word;
    }
}