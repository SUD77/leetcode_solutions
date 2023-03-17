class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m][n];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(m,n,0,0,dp);
    }
    
    public int solUtil(int m,int n,int i,int j,int[][] dp){
        
        if(i>=m || j>=n ) return 0;
        
        if(i==m-1 && j==n-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int down=solUtil(m,n,i,j+1,dp);
        int left=solUtil(m,n,i+1,j,dp);
       
        
        return dp[i][j]=down+left;
    }
}