class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidCol(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int i) {

        HashMap<Character, Integer> map = new HashMap<>();


        for (int j = 0; j < 9; j++) {
            char curr = board[i][j];

            if (curr != '.'){
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                
                if (map.get(curr) > 1) {
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < 9; j++) {
            char curr = board[j][col];

            if (curr != '.') {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                if (map.get(curr) > 1){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int box) {

        HashMap<Character, Integer> map = new HashMap<>();


        int startRow = 3 * (box / 3);
        int startCol = 3 * (box % 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char curr = board[startRow+i][startCol+j];

                if (curr != '.'){
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                    if (map.get(curr) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}