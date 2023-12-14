class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s== null)
            return 0;
        Set set=new HashSet();
        int j=0,max=0;
        for(int i=0;i<s.length();i++){
            while(!set.add(s.charAt(i)))
                set.remove(s.charAt(j++));
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}