class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(m,n,0,0,dp);
    }
    
    public int solUtil(int m,int n,int i,int j,int[][] dp){
        
        if(i>=m || j>=n) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(i==m-1 && j==n-1) return dp[i][j]=1;
            
        int down =solUtil(m,n,i+1,j,dp);
        int right=solUtil(m,n,i,j+1,dp);
        
        return dp[i][j]=down+right;
    }
}