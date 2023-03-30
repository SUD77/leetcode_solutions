class Solution {
    public int change(int amount, int[] coins) {
        
        int n=coins.length;
        
        int[][] dp=new int[n][amount+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);    
        }
        
        return solUtil(n-1,amount,coins,dp);
    }
    
    public int solUtil(int ind,int amount,int[] coins,int[][] dp){
        
        if(ind==0){
            
            if(amount%coins[ind]==0) return 1;
            else return 0;
        }
        
        if(dp[ind][amount]!=-1) return dp[ind][amount]; 
        
        int notPick=solUtil(ind-1,amount,coins,dp);
        
        int pick=0;
        
        if(amount >=coins[ind]){
            pick=solUtil(ind,amount-coins[ind],coins,dp);
        }
        
        return dp[ind][amount]=pick+notPick;
        
    }
}