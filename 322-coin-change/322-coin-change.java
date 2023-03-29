class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int n=coins.length;
        
        int[][] dp=new int[n][amount+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        if(solUtil(coins,amount,n-1,dp)!=(int)(Math.pow(10,9)))
            return solUtil(coins,amount,n-1,dp);
        
        return -1;
    }
    
    public int solUtil(int[] coins,int amount,int ind,int[][] dp){
        
        
        if(ind==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int)(Math.pow(10,9));
        }
        
        if(dp[ind][amount]!=-1) return dp[ind][amount]; 
        
        int notPick=solUtil(coins,amount,ind-1,dp);
        
        int pick=Integer.MAX_VALUE;
        
        if(amount>=coins[ind]){
            pick=1+solUtil(coins,amount-coins[ind],ind,dp);
        }
        
        return dp[ind][amount]=Math.min(pick,notPick);
    }
}