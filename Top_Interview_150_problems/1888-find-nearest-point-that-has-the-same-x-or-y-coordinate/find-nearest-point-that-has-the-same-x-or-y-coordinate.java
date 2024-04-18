class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int min = Integer.MAX_VALUE;

        int index = -1;

        for (int i = 0; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            if (x == x2 || y == y2) {
                
                int prevMin = min;
                min = Math.min(min, Math.abs(x - x2) + Math.abs(y - y2));
                if (min != prevMin) {
                    index = i;
                }
            }
        }

        return index;

    }
}