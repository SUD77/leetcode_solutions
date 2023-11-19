//Memoization


class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        
        Arrays.fill(dp,-1);
        
        return solUtil(n,dp);
    }
    
    public int solUtil(int n,int[] dp){
        if(n<=3) return n;
        
        if(dp[n]!=-1) return dp[n];
        
        return dp[n]=solUtil(n-1,dp) + solUtil(n-2,dp);
    }
}