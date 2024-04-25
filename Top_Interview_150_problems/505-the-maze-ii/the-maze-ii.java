class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Up, Down, Right, Left


    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n]; // To store distances for each cell

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize with maximum value
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0; // Distance from start is 0

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // Explore in all directions from the current position
            for (int[] dir : DIRECTIONS) {
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];
                int count = 0;
                // Roll until we hit a wall or the border
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                    count++;
                }

                if (distance[current[0]][current[1]] + count < distance[row-dir[0]][col - dir[1]]) {
                    queue.offer(new int[]{row - dir[0], col - dir[1]});
                    distance[row-dir[0]][col - dir[1]] = distance[current[0]][current[1]] + count; // Update distance
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]]; // No path found
    }
}