class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        
        int[][] dp=new int[n+1][2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(prices,0,1,fee,dp);
    }
    
    public int solUtil(int[] prices,int i,int buy,int fee,int[][] dp){
        
        //if(fee==0) return 0;
        if(i==prices.length) return 0;
    
        if(dp[i][buy]!=-1) return dp[i][buy];
        
        int profit=0;
        
        if(buy==1){
            profit=Math.max(-prices[i]+solUtil(prices,i+1,0,fee,dp),solUtil(prices,i+1,1,fee,dp));
        }else{
             profit=Math.max(prices[i]-fee+solUtil(prices,i+1,1,fee,dp),solUtil(prices,i+1,0,fee,dp));
        }
        
        return dp[i][buy]=profit;
    }
}