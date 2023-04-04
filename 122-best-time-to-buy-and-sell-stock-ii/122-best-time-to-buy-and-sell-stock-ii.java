//Memoization
//TC- O(n*2) 
//SC - O(n * 2) + O(n)
class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        
        int[][] dp=new int[n+1][2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(prices,0,1,dp);
    }
    
    public int solUtil(int[] prices,int index,int buy,int[][] dp){
        
        if(index==prices.length) return 0;
        
        if(dp[index][buy]!=-1) return dp[index][buy];
        
        int profit=0;
        if(buy==1){
            profit= Math.max(- prices[index] + solUtil(prices,index+1,0,dp), solUtil(prices,index+1,1,dp));
        }else{
            profit= Math.max( prices[index] + solUtil(prices,index+1,1,dp), solUtil(prices,index+1,0,dp));
        }
        
        return dp[index][buy]=profit;
    }
}