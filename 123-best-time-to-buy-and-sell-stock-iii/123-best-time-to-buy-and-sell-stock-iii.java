class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int k=2;
        
        int[][][] dp=new int[n+1][2][k+1];
        
        
        /* Doint all values to zero will ensure that our base cases are captured here
        i.e of dp[0..to..n][0 or 1][0] = 0 and similarly for when index is n, everything will be 0. Look at strivers video, if any doubt*/
        for(int[][] x:dp){
            for(int[] y:x){
                Arrays.fill(y,0);
            }
        }
        
        for(int index=n-1;index>=0;index--){
            
            for(int buy=0;buy<=1;buy++){
                
                for(int cap=1;cap<=2;cap++){
                    
                    if(buy==1){
                        dp[index][buy][cap]=Math.max(-prices[index]+dp[index+1][0][cap],dp[index+1][1][cap]);
                    } else {
                        dp[index][buy][cap]= Math.max(prices[index] + dp[index+1][1][cap-1] , dp[index+1][0][cap]);
                    }
                }
            }
        }
        
        return dp[0][1][k];
    }
    
   
}