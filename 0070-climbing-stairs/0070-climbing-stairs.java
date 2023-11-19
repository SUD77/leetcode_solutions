//Tabulation
// Tc - O(N)
// SC - O(N)

class Solution {
    public int climbStairs(int n) {
        
        if(n<=3) return n;
        int[] dp=new int[n+2];
        
        for(int i=0;i<=3;i++){
            dp[i]=i;
        }
        
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
}