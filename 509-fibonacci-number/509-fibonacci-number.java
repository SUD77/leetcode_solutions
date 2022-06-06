class Solution {
    
    int[] dp=new int[0];
    
    public int fib(int n) {
        
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solUtil(n);
    }
    
    public int solUtil(int n){
        
        if(dp[n]!=-1) return dp[n];
        
        if(n==0 || n==1){
            dp[n]=n;
            return dp[n];
        }
        
        int fib1=solUtil(n-1);
        int fib2=solUtil(n-2);
        
        dp[n]=fib1+fib2;
        
        return dp[n];
    }
}