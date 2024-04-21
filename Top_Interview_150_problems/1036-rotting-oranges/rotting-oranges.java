class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Up, down, left, right


    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;

        // Initialize - Add rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // Add rotten orange with time 0
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            time = Math.max(time, current[2]); // Track the maximum time

            for (int[] dir : DIRECTIONS) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol, current[2] + 1});
                    freshOranges--; 
                }
            }
        }

        return (freshOranges == 0) ? time : -1;
    }
}