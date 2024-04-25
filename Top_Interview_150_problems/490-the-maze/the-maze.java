class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Up, Down, Right, Left

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true; // Found the destination
            }

            for (int[] dir : DIRECTIONS) {
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];

                // Keep rolling in the same direction until hitting a wall or boundary
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }

                // Backtrack one step to the valid position before the wall
                row -= dir[0]; 
                col -= dir[1]; 

                if (!visited[row][col]) {
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }

        return false; // Destination not reachable
    }


}