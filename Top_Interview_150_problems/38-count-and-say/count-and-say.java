class Solution {
    public String countAndSay(int n) {
        
        // Initialize the first term of the sequence as "1"
        String val = "1";
        // Loop to generate the n-th term of the sequence
        for(int i=0; i<n-1; i++) {
            
            // Initialize the first character of the current term
            char ch = val.charAt(0);

             // StringBuilder to build the next term
            StringBuilder sb = new StringBuilder();

            // Counter for the counting of occurrences of the current character
            int count = 1;

            // Loop through the characters of the current term
            for(int j=1; j<val.length(); j++) {
                
                //If the currnet character is different from ch, it mean we have to update the sb.
                if(ch != val.charAt(j)) {
                    // So we update the count
                    sb.append(count);
                    // update the number
                    sb.append(ch);
                    // Set the count to 0 again.
                    count = 0;
                    //Now the add the character to ch which is not equal to previous
                    ch = val.charAt(j);
                }
                count++;
            }
            // again do the same thing after coming out of the loop.
            sb.append(count);
            sb.append(ch);
            val = sb.toString();
        }
        return val;
    }
}