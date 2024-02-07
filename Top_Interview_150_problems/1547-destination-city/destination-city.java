class Solution {
    public String destCity(List<List<String>> paths) {

        HashMap<String, String> map = new HashMap<>();

        for (List<String> path: paths) {
            map.put(path.get(0), path.get(1));
        }

        for (String dest : map.values()){ 
            if (!map.containsKey(dest)){
                return dest;
            }
        }

        return "";
        
    }
}