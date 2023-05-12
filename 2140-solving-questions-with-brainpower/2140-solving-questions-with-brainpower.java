class Solution {
    public long mostPoints(int[][] questions) {
        
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        
        return solUtil(questions,0,dp);
    }
    
    public long solUtil(int[][] questions,int index,long[] dp){
        
        if(index>=questions.length) return 0;
        
        if(dp[index]!=-1) return dp[index];
        
        long take=questions[index][0]+solUtil(questions,index+questions[index][1]+1,dp);
        
        long notTake=solUtil(questions,index+1,dp);
        
        return dp[index]=Math.max(take,notTake);
        
    }
}