class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // Create a HashMap to store character counts
        HashMap<Character, Integer> dictionary = new HashMap<>();

        // Iterate through the characters in the magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            
            // If the character is not present in the HashMap, add it with count 1
            if (!dictionary.containsKey(c)) {
                dictionary.put(c, 1);
            } else {
                // If the character is already present, increment its count by 1
                dictionary.put(c, dictionary.get(c) + 1);
            }
        }
        
        // Iterate through the characters in the ransom note
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            
            // If the character is present in the HashMap and its count is greater than 0,
            // decrement its count by 1
            if (dictionary.containsKey(c) && dictionary.get(c) > 0) {
                dictionary.put(c, dictionary.get(c) - 1);
            } else {
                // If the character is not present or its count is 0, return false
                return false;
            }
        }
        
        // All characters in the ransom note have been processed successfully,
        // so the ransom note can be formed from the magazine
        return true;
    }
}