class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
            return;
        }
        board[i][j] = '.'; // mark as visited
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}