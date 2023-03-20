class Solution {
    public int minPathSum(int[][] grid) {
     
        int m=grid.length;
        int n=grid[0].length;
        
        int[][] dp=new int[m][n];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(0,0,m,n,grid,dp);
    }
    
    public int solUtil(int i,int j,int m,int n,int[][] grid,int[][] dp){
        
        if(i==m-1 && j==n-1) return grid[i][j];
        if(i >=m || j>=n) return Integer.MAX_VALUE;
        
        if(dp[i][j]!=-1) return dp[i][j];
    
        int curr=grid[i][j];
        
        int left=solUtil(i,j+1,m,n,grid,dp);
        int down=solUtil(i+1,j,m,n,grid,dp);
        
        return dp[i][j]=curr+Math.min(left,down);
    }
}