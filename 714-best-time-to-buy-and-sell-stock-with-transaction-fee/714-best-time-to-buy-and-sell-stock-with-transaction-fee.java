class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        
       int n=prices.length;
        
        int[][] dp=new int[n+1][2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(prices,n,0,1,fee,dp);
    }
    
    public int solUtil(int[] prices,int n,int index,int buy,int fee,int[][] dp){
        
        if(index==n) return 0;
        
        if(dp[index][buy]!=-1) return dp[index][buy];
            
        int profit=0;
        
        if(buy==1){
            
            profit=Math.max(-prices[index] + solUtil(prices,n,index+1,0,fee,dp), solUtil(prices,n,index+1,1,fee,dp));
        }else{
            
            profit=Math.max(prices[index]-fee + solUtil(prices,n,index+1,1,fee,dp),solUtil(prices,n,index+1,0,fee,dp));
        }
        
        
        return dp[index][buy]=profit;
    }
}