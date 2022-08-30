class Solution {
    public void rotate(int[][] matrix) {
        
        
        /*
         * clockwise rotate
         * first reverse up to down, then swap the symmetry 
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
        */
        
        int start=0;
        int end=matrix.length-1;
        
        while(start<end){
            
            int[] temp=matrix[start];
            matrix[start]=matrix[end];
            matrix[end]=temp;
            start++;
            end--;
        }
        
        for(int i=0;i<matrix.length;i++){
            
            for(int j=i+1; j<matrix[i].length;j++){
                
                int temp=matrix[i][j];
                
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
            
        
    }
}