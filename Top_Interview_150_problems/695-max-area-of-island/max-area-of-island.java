class Solution {

     public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, calculateAreaIterative(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int calculateAreaIterative(int[][] grid, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        grid[row][col] = 0; // Mark as visited
        int area = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            area++;

            // Explore valid neighbors
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0; // Mark as visited
                }
            }
        }
        return area;
    }

}