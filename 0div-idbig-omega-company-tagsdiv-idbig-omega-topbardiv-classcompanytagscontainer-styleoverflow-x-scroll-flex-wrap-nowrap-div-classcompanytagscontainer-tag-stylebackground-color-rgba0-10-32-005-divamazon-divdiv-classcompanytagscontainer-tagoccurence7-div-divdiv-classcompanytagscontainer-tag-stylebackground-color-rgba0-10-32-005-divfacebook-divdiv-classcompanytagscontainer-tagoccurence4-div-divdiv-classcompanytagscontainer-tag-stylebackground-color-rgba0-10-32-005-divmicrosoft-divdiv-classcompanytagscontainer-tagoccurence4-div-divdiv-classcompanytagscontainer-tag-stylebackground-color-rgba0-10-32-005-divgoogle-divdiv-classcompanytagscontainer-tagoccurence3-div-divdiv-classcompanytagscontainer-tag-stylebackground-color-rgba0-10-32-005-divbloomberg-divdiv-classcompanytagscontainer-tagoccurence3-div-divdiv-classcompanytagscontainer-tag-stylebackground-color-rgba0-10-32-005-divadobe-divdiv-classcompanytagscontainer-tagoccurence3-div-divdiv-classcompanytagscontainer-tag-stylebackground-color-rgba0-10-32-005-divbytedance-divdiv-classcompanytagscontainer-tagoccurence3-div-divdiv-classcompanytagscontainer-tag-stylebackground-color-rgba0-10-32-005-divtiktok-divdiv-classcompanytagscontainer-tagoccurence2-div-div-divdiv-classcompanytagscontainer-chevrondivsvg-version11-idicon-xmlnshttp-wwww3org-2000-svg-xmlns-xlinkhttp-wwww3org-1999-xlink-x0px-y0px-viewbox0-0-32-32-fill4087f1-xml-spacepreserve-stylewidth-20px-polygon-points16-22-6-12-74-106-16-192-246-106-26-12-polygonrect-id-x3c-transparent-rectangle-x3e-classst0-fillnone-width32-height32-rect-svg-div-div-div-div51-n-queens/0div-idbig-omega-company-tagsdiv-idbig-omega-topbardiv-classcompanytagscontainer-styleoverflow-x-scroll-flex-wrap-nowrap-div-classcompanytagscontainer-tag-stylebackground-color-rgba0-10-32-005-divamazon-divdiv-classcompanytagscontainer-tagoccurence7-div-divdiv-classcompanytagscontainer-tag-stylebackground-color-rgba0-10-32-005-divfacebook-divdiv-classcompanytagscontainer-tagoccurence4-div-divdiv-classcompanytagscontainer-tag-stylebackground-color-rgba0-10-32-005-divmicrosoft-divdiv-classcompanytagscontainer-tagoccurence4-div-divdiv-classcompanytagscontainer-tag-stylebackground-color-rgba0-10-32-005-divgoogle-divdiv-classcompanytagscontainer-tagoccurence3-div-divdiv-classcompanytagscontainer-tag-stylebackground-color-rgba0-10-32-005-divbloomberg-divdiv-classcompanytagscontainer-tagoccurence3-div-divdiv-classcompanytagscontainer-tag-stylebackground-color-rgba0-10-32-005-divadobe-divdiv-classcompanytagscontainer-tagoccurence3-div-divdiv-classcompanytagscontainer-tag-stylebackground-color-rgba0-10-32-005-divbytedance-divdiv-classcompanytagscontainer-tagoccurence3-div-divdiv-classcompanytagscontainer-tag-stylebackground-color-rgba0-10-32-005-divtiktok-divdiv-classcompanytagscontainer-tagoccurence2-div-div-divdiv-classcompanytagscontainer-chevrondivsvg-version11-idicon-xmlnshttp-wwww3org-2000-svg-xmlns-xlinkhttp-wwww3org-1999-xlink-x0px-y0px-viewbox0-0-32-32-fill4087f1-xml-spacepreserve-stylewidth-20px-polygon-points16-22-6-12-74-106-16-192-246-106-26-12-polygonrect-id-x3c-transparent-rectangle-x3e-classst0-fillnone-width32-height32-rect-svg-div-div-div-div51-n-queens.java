/*
N - queens
TC = O(N!) 
The first queen has N options, the second queen has (N-1) options (because it cannot be placed in the same row, same column, or on the same diagonal as the first queen), and so on.
Therefore, the worst-case time complexity is O(N * (N-1) * (N-2) * ... * 1) = O(N!).

SC = O(N x N) board + O(N) stack space + O(N x N!)
the space complexity is O(N^2) (for the board) + O(N) (for the recursion stack) + O(N * N!) (for storing the solutions).

*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        List<List<String>> res=new ArrayList<>();
        
        solUtil(0,board,res);
        
        return res;
    }
    
    
    public void solUtil(int col,char[][] board,List<List<String>> res){
        
        if(col==board.length){
            res.add(convertBoardArrayToListOfString(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            
            if(isSafe(row,col,board)){
                
                board[row][col]='Q';
                solUtil(col+1,board,res);
                board[row][col]='.';
            }
        }
    }
    
    public boolean isSafe(int row,int col,char[][] board){
        
        int n=board.length;
        
        int dupCol=col;
        int dupRow=row;
        
        
        //check upper diagonal
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        //reset row and col
        col=dupCol;
        row=dupRow;
        
        // check row 
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        
        //reset row and col
        col=dupCol;
        row=dupRow;
        
        //check lower diagonal
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            col--;
            row++;
        }
        
        
        return true;
    }
    
    
    public List<String> convertBoardArrayToListOfString(char[][] board){
     
        List<String> tempString=new ArrayList<>();
        
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            tempString.add(s);
        }
        
        return tempString;
    }
}