class Solution {
    public int countBattleships(char[][] board) {
        
        int n=board.length;
        int m=board[0].length;
        
        int count=0;
        
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && !vis[i][j]){
                    solUtil(board,vis,i,j);
                    count++;
                }
            }
        }
        
        // for(boolean[] x:vis){
        //     System.out.println(x);
        // }
        
        return count;
    }
    
    public void solUtil(char[][] board,boolean[][] vis,int i,int j){
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        
        if(board[i][j]=='.') return;
        //System.out.println("i" + i + "j : " + j);
        if(vis[i][j]) return;
        
        vis[i][j]=true;
        
        
        // up, down, right ,left
        solUtil(board,vis,i-1,j);
        solUtil(board,vis,i+1,j);
        solUtil(board,vis,i,j-1);
        solUtil(board,vis,i,j+1);
    }
}