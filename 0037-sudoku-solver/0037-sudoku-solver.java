class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    
    boolean solve(char[][] board){
        
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board.length;j++){
                
                if(board[i][j]=='.'){
                    
                    for(char c='1';c<='9';c++){
                        
                        if(isValid(board,i,j,c)){
                            
                            board[i][j]=c;
                            
                            if(solve(board)) return true;
                            else board[i][j]='.';
                        }
                        
                    } // end of for
                    
                    return false;
                    
                } // end of if
            }
        }
        
        return true;
    }
    
    boolean isValid(char[][] board,int row,int col,char c){
        
        for(int i=0;i<9;i++){
            
            //to check in column
            if(board[i][col]==c) return false;
            
            //to check in row
            if(board[row][i]==c) return false;
            
            
            //to check in 3 * 3 matrix
            int localRow= 3 * (row/3)  + i/3;
            int localCol = 3 * (col/3) + i%3;
            if(board[localRow][localCol]==c) return false;
        }
        
        return true;
    }
    
    
    
}