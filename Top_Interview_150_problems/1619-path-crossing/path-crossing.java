class Solution {
    public boolean isPathCrossing(String path) {

        HashMap<Integer, Set<Integer>> coord = new HashMap<>();

        int x = 0, y = 0;

        Set<Integer> s = new HashSet<>(1);
        s.add(0);
        coord.put(x, s);

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'W') {
                x--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else {
                y--;
            }
            if (coord.containsKey(x) && coord.get(x).contains(y)){
                return true;
            }
            if (coord.containsKey(x)){
                coord.get(x).add(y);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(y);
                coord.put(x, set);
            }

        }


        return false;
        
    }
}