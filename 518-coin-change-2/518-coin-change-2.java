class Solution {
    public int change(int amount, int[] coins) {
      
        int n=coins.length;
        
        int[][] dp=new int[n][amount+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(n-1,coins,amount,dp);
    }
    
    public int solUtil(int index,int[] coins,int amount,int[][] dp){
        
        if(index==0){
            
            if(amount%coins[index]==0) return 1;
            
            return 0;
        }
        
        if(amount==0) return 1;
        
        if(dp[index][amount]!=-1) return dp[index][amount];
        
        int notTake=solUtil(index-1,coins,amount,dp);
        
        int take=0;
        if(coins[index]<=amount){
            take=solUtil(index,coins,amount-coins[index],dp);
        }
        
        
        return dp[index][amount]=notTake+take;
    }
}