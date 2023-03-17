// TC - O(mn)  SC - O(m+n)+ O(mn)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[][] dp=new int[m][n];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(0,0,m,n,obstacleGrid,dp);
    }
    
    public int solUtil(int i,int j,int m,int n,int[][] obstacleGrid,int[][] dp){
        
        if(i>=m || j>=n) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        
        if(i==m-1 && j==n-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int down=solUtil(i+1,j,m,n,obstacleGrid,dp);
        int right=solUtil(i,j+1,m,n,obstacleGrid,dp);
        
        return dp[i][j]=down+right;
    }
}