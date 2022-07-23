class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int n=coins.length;
        
        int[][] dp=new int[n][amount+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        if(solUtil(coins,n-1,amount,dp)!=(int)Math.pow(10,9))
            return solUtil(coins,n-1,amount,dp);
        
        return -1;
    }
    
    public int solUtil(int[] coins,int index,int amount,int[][] dp){
        
        
        if(dp[index][amount]!=-1) return dp[index][amount];
        if(index==0) 
        {
        
            if(amount%coins[index]==0) return dp[index][amount]=amount/coins[index];
            else return dp[index][amount]=(int)Math.pow(10,9);
        }
        
        int notTake=solUtil(coins,index-1,amount,dp);
        
        int take=(int)Math.pow(10,9);
        if(coins[index]<=amount){
            take=1+solUtil(coins,index,amount-coins[index],dp);
        }
        
        return dp[index][amount]=Math.min(take,notTake);
    }
}