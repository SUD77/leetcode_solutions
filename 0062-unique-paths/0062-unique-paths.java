class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(0,0,m,n,dp);
        
    }
    
    public int solUtil(int i,int j,int m,int n,int[][] dp){
        
        if(i>m || j>n) return 0;
        
        if(i==m-1 && j==n-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        
        int down=solUtil(i+1,j,m,n,dp);
        int right=solUtil(i,j+1,m,n,dp);
        
        
        return dp[i][j]=down + right;
    }
}