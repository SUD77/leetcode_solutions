class Solution {
    public int equalPairs(int[][] grid) {
        
         int count=0;

        int n=grid.length;

        int[][] rowA=new int[n][n];
        int[][] colA=new int[n][n];

        for(int i=0;i<grid.length;i++){
            rowA[i]=grid[i];
        }

        //storing col data
        int colCheck=0;
        int colItr=0;
        while(colCheck<grid[0].length){

            for(int row=0;row<grid.length;row++){
                colA[colItr][row]=grid[row][colCheck];
            }
            colItr++;
            colCheck++;
        }


        for(int j=0;j< grid.length;j++) {

            for (int i = 0; i < grid.length; i++) {
                if (Arrays.equals(rowA[j], colA[i])) count++;
            }
        }
        return count;
    }
}