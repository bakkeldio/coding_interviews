class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int right= words[i].length() - 1;

            while(right >= 0) {
                str.append(words[i].charAt(right));
                right--;
            }

            if (i != words.length - 1){
                str.append(" ");
            }
        }

        return str.toString();
    }
}