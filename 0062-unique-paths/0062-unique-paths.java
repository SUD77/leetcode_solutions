//Memoization 
//TC - O((m*n))
// SC - O(m+n) + O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(m-1,n-1,m,n,dp);
    }
    
    public int solUtil(int i,int j,int m,int n,int[][] dp){
        
        if(i<0 || j<0) return 0; 
        
        if(i==0 && j==0) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int left=solUtil(i,j-1,m,n,dp);
        int up=solUtil(i-1,j,m,n,dp);
        
        
        return dp[i][j]=left + up;
        
        
    }
}