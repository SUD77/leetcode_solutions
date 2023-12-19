// SC - O(n) + O(m)
// TC - O(n*m)

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        int[] dumRow=new int[row];
        int[] dumCol=new int[col];
        
        int r=0;
        int c=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    dumRow[i]=-1;
                    dumCol[j]=-1;
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dumRow[i]==-1 || dumCol[j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
        
        
        
    }
}