import java.util.Hashtable;
class Solution {
   public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> hashtable = new HashMap<>();
       
       
       for (int i = 0; i < s.length(); i++) 
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (hashtable.containsKey(c1))
            {
                if (hashtable.get(c1) != c2) return false;
            }else {
                if (hashtable.containsValue(c2)) return false;
                hashtable.put(c1 , c2);
            }
        }
       
       return true;
    }
}