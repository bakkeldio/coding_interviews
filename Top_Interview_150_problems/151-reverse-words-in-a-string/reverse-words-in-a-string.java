class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        
        String reverseWords = "";
        for (int i = arr.length - 1; i >= 0; i--){
            reverseWords += arr[i];
            if (i != 0){
                reverseWords += " ";
            }
        }
        return reverseWords;
    }
}