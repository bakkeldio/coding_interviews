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
                return true; // Reached the destination
            }

            // Explore in all directions from the current position
            for (int[] dir : DIRECTIONS) {
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];

                // Roll until we hit a wall or the border
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }

                // Backtrack one step to the position where the ball stopped
                row -= dir[0]; 
                col -= dir[1];

                if (!visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        return false; // No path found
    }


}