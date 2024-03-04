class Solution {

     public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean[][] seen = new boolean[rows][cols]; // keep track of visited cells

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    int shapeArea = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    seen[i][j] = true; // mark as visited

                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        int row = current[0], col = current[1];
                        shapeArea++;

                        // explore neighbors
                        for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                            int nr = row + dir[0], nc = col + dir[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, shapeArea);
                }
            }
        }
        return maxArea;

    }

}