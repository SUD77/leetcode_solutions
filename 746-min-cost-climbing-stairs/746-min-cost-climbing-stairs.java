class Solution {
    
    int[] dp=new int[0];
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return solUtil(cost,n);
    }
    
    public int solUtil(int[] cost,int n){
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        if(n==0 || n==1) {
            dp[n]=cost[n];
            return dp[n];
        }
        
        
        int first=solUtil(cost,n-1);
        int second=solUtil(cost,n-2);
        
        if(n==cost.length){
            dp[n]=0+Math.min(dp[n-1],dp[n-2]);
        }
        else dp[n]=cost[n]+Math.min(dp[n-1],dp[n-2]);
        return dp[n];
        
        
    }
}