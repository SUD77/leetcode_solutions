class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int k=2;
        
        int[][][] dp=new int[n][2][k+1];
        
        for(int[][] x:dp){
            for(int[] y:x){
                Arrays.fill(y,-1);
            }
        }
        
        return solUtil(prices,n,0,1,k,dp);
    }
    
    public int solUtil(int[] prices,int n,int index,int buy,int transaction,int[][][] dp){
        
        
        
        if(transaction==0) return 0;
        if(index==n) return 0;
        
        if(dp[index][buy][transaction]!=-1) return dp[index][buy][transaction];
        
        int profit=0;
        
        if(buy==1){
            
            profit=Math.max(-prices[index]+solUtil(prices,n,index+1,0,transaction,dp),solUtil(prices,n,index+1,1,transaction,dp));
        }else{
            
            profit=Math.max(prices[index] + solUtil(prices,n,index+1,1,transaction-1,dp) , solUtil(prices,n,index+1,0,transaction,dp));
        }
        
        return dp[index][buy][transaction]=profit;
        
    }
}