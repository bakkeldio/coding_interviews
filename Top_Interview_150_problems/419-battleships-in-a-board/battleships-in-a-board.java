class Solution {
    
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        // Mark visited cells to avoid revisiting
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, visited, i, j);
                    count++; // Increment count after sinking a battleship
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X' || visited[i][j]) {
            return; // Out of bounds, water, or already visited
        }

        visited[i][j] = true; // Mark the cell as visited

        // Recursively sink the battleship in all directions
        dfs(board, visited, i + 1, j); // Down
        dfs(board, visited, i - 1, j); // Up
        dfs(board, visited, i, j + 1); // Right
        dfs(board, visited, i, j - 1); // Left
    }

}