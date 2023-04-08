//Memoization
// TC - O(n*2*2) 
// SC - O(n) + O(n*2*3)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int[][][] dp=new int[n][2][3];
        
        for(int[][] x:dp){
            for(int[] y:x){
                Arrays.fill(y,-1);
            }
        }
        
        return solUtil(prices,0,1,2,dp);
    }
    
    public int solUtil(int[] prices,int i,int buy,int k,int[][][] dp){
        
        if(k==0) return 0;
        if(i==prices.length) return 0;
        
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        
        int profit=0;
        if(buy==1){
            profit= Math.max(-prices[i] + solUtil(prices,i+1,0,k,dp),solUtil(prices,i+1,1,k,dp));
        }else{
            profit= Math.max(prices[i] + solUtil(prices,i+1,1,k-1,dp),solUtil(prices,i+1,0,k,dp));
        }
        
        return dp[i][buy][k]=profit;
    }
}