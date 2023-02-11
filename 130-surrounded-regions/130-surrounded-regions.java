class Solution {
    public void solve(char[][] board) {
    
        int m=board.length;
        int n=board[0].length;
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        boolean[][] vis=new boolean[m][n];
        
        //traverse first and last row
        for(int j=0;j<n;j++){
            
            if(!vis[0][j] && board[0][j]=='O') dfs(board,0,j,vis,delRow,delCol);
            
            if(!vis[m-1][j] && board[m-1][j]=='O') dfs(board,m-1,j,vis,delRow,delCol);
        }
        
        
        //traverse first and last column
        for(int i=0;i<m;i++){
            
            if(!vis[i][0] && board[i][0]=='O') dfs(board,i,0,vis,delRow,delCol);
            
            if(!vis[i][n-1] && board[i][n-1]=='O') dfs(board,i,n-1,vis,delRow,delCol);
        }
        
       
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    
    public void dfs(char[][] board,int row,int col,boolean[][] vis,int[] delRow,int[] delCol){
       
        vis[row][col]=true;
        
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<4;i++){
            
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            
            
            if(nRow >=0 && nRow<m && nCol>=0 && nCol<n && !vis[nRow][nCol] && board[nRow][nCol]=='O')
                dfs(board,nRow,nCol,vis,delRow,delCol);
        }
    }
    
    
}