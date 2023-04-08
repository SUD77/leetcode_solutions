//Tabulation
// TC - O(n*2*2) 
// SC - O(n*2*3)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int[][][] dp=new int[n+1][2][3];
        
        for(int i=n;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int k=0;k<3;k++){
                    if(k==0){
                        dp[i][buy][k]=0;
                    }else if(i==n){
                        dp[i][buy][k]=0;
                    }else{
                        int profit=0;
                        if(buy==1){
                            profit= Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                        }else{
                            profit= Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]); 
                        }

                        dp[i][buy][k]=profit;
                    }
                }
            }
        }
        
        return dp[0][1][2]; 
    }
    
}