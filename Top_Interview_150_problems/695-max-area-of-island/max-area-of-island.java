class Solution {
    
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    int n; 
    int m;
    int answer = 0;

    
    public int maxAreaOfIsland(int[][] grid) {
        
        n = grid.length; 
        m = grid[0].length;
            
        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    answer = 1;
                    dfs(i, j, grid, visited);
                    max = Math.max(max, answer);
                }
            }
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    
    }
    
    public boolean isValid(int i, int j, int[][] graph) {
        return i >= 0 && i < n && j >= 0 && j < m && graph[i][j] == 1;
    }
    
    public void dfs(int i, int j, int[][] graph, boolean[][] visited) {
        for (int[] direction : directions) {
            int r = i + direction[0];
            int c = j + direction[1];
            
            if (isValid(r, c, graph) && !visited[r][c]) {
                visited[r][c] = true;
                answer++;
                dfs(r, c, graph, visited);
            }
        } 
    }
}