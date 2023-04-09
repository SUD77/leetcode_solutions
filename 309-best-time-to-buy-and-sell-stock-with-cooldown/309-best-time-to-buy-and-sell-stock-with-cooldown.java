//tabulation
// TC - O(n*2)
//SC - O(n*2)


class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        
        int[][] dp=new int[n+2][2];  //took size n+2 as, i is going till i+2
        
        for(int i=n+1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                
                if(i>=n) dp[i][buy]=0;
                else{
                    int profit=0;
                    if(buy==1){
                        profit=Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]); 
                    }else{
                        
                        int sellNow=prices[i] + dp[i+2][1];
                        int sellLater=dp[i+1][0];
                        profit=Math.max(sellNow,sellLater); 
                    }
                    
                    dp[i][buy]=profit;
                }
                
            }
        }
        return dp[0][1];
    }
    
}