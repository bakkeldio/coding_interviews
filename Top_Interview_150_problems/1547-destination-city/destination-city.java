class Solution {
    public String destCity(List<List<String>> paths) {

        HashMap<String, String> map = new HashMap<>();

        Set<String> set = new HashSet<>();


        for (List<String> path: paths) {
            map.put(path.get(0), path.get(1));
            set.add(path.get(1));
        }

        for (String dest : set){ 
            if (!map.containsKey(dest)){
                return dest;
            }
        }

        return "";
        
    }
}