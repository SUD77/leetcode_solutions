class Solution {
    public int numEnclaves(int[][] board) {
       
        
        int r=board.length;
        int c=board[0].length;
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        boolean[][] vis=new boolean[r][c];
        
        //traverse first and last row
        for(int j=0;j<c;j++){
            //first row
            if(!vis[0][j] && board[0][j]==1) dfs(board,0,j,vis);
            //last row
            if(!vis[r-1][j] && board[r-1][j]==1) dfs(board,r-1,j,vis);
        }
        
        
        //traverse first and last column
        for(int i=0;i<r;i++){
            //first column
            if(!vis[i][0] && board[i][0]==1) dfs(board,i,0,vis);
            //last column
            if(!vis[i][c-1] && board[i][c-1]==1) dfs(board,i,c-1,vis);
        }
        
        int count=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1 && !vis[i][j] ) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
     public void dfs(int[][] board,int row,int col,boolean[][] vis){
        
        if(row<0 || row>=board.length || col<0 || col>=board[0].length) return;
        if(vis[row][col] == true) return;
        if(board[row][col] == 0) return;
        
        vis[row][col]=true;
        
        dfs(board, row-1, col, vis); //up
        dfs(board, row+1, col, vis); //down
        dfs(board, row, col-1, vis); // left
        dfs(board, row, col+1, vis); //right       
    } 
}