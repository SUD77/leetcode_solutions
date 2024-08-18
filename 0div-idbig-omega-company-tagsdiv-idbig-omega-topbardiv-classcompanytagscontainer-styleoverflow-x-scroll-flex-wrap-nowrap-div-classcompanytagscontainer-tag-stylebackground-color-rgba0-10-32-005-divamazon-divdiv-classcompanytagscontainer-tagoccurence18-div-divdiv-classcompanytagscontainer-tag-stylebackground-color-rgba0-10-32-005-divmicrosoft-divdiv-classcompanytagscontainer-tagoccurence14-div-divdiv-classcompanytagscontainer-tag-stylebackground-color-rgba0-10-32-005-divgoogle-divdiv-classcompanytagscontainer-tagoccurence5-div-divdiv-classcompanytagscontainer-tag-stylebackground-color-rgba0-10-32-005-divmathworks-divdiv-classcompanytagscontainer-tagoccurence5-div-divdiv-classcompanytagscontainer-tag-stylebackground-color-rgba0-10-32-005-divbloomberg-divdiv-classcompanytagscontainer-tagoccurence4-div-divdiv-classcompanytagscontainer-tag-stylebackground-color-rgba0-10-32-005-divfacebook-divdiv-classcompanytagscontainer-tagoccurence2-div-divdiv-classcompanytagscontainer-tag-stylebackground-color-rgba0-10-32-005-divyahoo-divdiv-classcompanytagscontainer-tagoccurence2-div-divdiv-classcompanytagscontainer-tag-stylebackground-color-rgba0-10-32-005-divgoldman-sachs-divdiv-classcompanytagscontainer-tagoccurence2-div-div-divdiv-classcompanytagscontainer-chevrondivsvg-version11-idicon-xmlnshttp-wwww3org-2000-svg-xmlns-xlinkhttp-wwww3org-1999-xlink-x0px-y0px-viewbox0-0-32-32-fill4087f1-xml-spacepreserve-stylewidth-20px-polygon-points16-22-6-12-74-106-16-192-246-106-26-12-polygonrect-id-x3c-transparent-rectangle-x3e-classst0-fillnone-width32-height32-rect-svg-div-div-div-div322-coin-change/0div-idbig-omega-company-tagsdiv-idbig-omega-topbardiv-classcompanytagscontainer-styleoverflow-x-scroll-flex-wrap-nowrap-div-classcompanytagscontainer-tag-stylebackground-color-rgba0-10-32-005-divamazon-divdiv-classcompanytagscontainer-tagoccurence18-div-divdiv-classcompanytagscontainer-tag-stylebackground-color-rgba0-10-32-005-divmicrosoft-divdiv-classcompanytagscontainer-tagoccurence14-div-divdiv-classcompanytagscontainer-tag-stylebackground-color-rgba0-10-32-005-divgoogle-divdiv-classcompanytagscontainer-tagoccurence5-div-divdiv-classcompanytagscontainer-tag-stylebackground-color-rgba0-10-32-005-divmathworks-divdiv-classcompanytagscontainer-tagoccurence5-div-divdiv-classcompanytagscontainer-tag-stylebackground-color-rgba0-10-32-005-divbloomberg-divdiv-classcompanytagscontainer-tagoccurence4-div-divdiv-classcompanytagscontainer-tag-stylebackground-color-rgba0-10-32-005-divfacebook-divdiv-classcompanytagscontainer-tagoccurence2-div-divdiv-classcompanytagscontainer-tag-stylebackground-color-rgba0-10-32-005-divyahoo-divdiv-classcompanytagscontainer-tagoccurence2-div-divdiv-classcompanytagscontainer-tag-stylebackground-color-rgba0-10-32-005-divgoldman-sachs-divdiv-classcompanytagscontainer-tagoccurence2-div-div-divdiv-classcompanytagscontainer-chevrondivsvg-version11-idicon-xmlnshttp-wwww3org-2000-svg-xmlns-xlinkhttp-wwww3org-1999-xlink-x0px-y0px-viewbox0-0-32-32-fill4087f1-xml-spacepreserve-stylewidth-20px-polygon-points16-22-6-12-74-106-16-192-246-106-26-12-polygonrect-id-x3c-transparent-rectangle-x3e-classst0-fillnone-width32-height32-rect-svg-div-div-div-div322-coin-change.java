//recursion
//TC = O(2^n)
//Sc = O(n) aux stack space

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;
        Arrays.sort(coins);
        
        int[][] dp=new int[n+1][amount+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        int x=solUtil(n-1,coins,amount,dp);
        if(x!=(int) Math.pow(10,9)) return x;
        
        return -1;
    }
    
    
    public int solUtil(int i,int[] coins,int amount,int[][] dp){
        
        if(i==0){
            if(amount%coins[0]==0){
                return amount/coins[i];
            }
            return (int)Math.pow(10,9);
        }
        
        
        if(dp[i][amount]!=-1) return dp[i][amount];
        
        
        int pick=(int)Math.pow(10,9);
        
        if(amount-coins[i]>=0){
            
            pick=1 + solUtil(i,coins,amount-coins[i],dp);
        }
        
        
        int notPick=solUtil(i-1,coins,amount,dp);
        
        return dp[i][amount]=Math.min(pick,notPick);
        
    }
}