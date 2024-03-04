class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        // Check if out of bounds or if current cell is water
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // Mark current cell as visited (sink the island)
        grid[row][col] = 0;

        int area = 1;  // Count the current cell

        // Explore neighbors recursively using DFS
        area += dfs(grid, row - 1, col); // Up
        area += dfs(grid, row + 1, col); // Down
        area += dfs(grid, row, col - 1); // Left
        area += dfs(grid, row, col + 1); // Right

        return area;
    }

}