class Solution {
    String lastWord = "";
    public int lengthOfLastWord(String s) {
        String word = "";
        boolean lastCharWasSpace = false;
        for (int i = 0; i < s.length(); i ++ ){
            if (s.charAt(i) == ' '){
                lastCharWasSpace = true;
                lastWord = word;
                continue;
            }
            if (lastCharWasSpace){
                word = "";
            }
            lastCharWasSpace = false;
            word += s.charAt(i);
            lastWord = word;
        }
        return lastWord.length();
    }
}