class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(0,0,grid,dp);
    }
    
    public int solUtil(int row,int col,int[][] grid,int[][] dp){
        
        //System.out.println("row" + row + "col" + col);
        
        if(row>=grid.length || col>=grid[0].length) return (int)1e8;
        if(row==grid.length-1 && col==grid[0].length-1) return grid[row][col];
        
        if(dp[row][col]!=-1) return dp[row][col];
        
        int down=grid[row][col] + solUtil(row+1,col,grid,dp);
        int right=grid[row][col] + solUtil(row,col+1,grid,dp);
        
        return dp[row][col]=Math.min(down,right);
    }
}