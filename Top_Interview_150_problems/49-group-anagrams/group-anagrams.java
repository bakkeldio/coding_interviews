class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
            
        for (String str: strs) {
            
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            
            groups.putIfAbsent(sorted, new ArrayList<>());
            
            groups.get(sorted).add(str);
        }
        
        return new ArrayList<List<String>>(groups.values());
    }
}