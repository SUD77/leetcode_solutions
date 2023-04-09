//Recursion
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        
        int[][][] dp=new int[n+1][2][k+1];
        
        
        
        for(int i=n;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int tran=0;tran<=k;tran++){
                   
                    if(i==n || tran==0){
                        dp[i][buy][tran]=0;
                    }
                    else{
                        int profit=0;
                        if(buy==1){
                            profit= Math.max(-prices[i] + dp[i+1][0][tran], dp[i+1][1][tran]);
                        }else{
                            profit= Math.max(prices[i] + dp[i+1][1][tran-1], dp[i+1][0][tran]); 
                        }

                        dp[i][buy][tran]=profit;
                    }
                }
            }
        }
        
        return dp[0][1][k];
    }
    
}