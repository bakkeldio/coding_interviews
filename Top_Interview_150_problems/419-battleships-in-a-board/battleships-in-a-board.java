class Solution {
    public int countBattleships(char[][] board)
    {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==false && board[i][j]=='X')
                {
                    dfs(i,j,board,vis);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j, char[][] board, boolean[][] vis)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j])
        {
            return;
        }
        
        if(board[i][j]=='.')
        {
            return;
        }
        
        vis[i][j]=true;
        dfs(i,j+1,board,vis);
        dfs(i+1,j,board,vis);
    }

}