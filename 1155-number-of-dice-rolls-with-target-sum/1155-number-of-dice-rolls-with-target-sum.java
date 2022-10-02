class Solution {
    
     int mod = (int)1e9+7;
    
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] dp=new int[n+1][target+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        
        return solUtil(n,k,target,dp);
    }
    
    public int solUtil(int n,int k,int target,int[][] dp){
        
        if(target<0) return 0;
        if(n==0 && target!=0) return 0;
        
        if(dp[n][target]!=-1) return dp[n][target];
        if(target==0 && n!=0) return dp[n][target]=0;
        if(target==0 && n==0) return dp[n][target]=1;
        
     
        
        int ans=0;
        
        for(int i=1;i<=k;i++){
            
            ans+=solUtil(n-1,k,target-i,dp);
            ans=ans%mod;
        }
        
        return dp[n][target]=ans;
    }
}