class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n=nums.length;
        int m=multipliers.length;
        
        int[][] dp=new int[m+1][m+1];
        
        for(int[] x:dp){
            Arrays.fill(x,Integer.MIN_VALUE);
        }
        
        return solUtil(dp,nums,multipliers,n,0,0);
        
    }
    
    public int solUtil(int[][] dp,int[] nums,int[] multipliers,int n,int mIndex,int nIndex){
        
        if(mIndex==multipliers.length) return 0;
    
        if(dp[mIndex][nIndex]!=Integer.MIN_VALUE) return dp[mIndex][nIndex]; 
        
        int takeFirst =  multipliers[mIndex]*nums[nIndex] + solUtil(dp,nums,multipliers,n,mIndex+1,nIndex+1);
        
        int takeLast = multipliers[mIndex]*nums[(n-1)-(mIndex-nIndex)] + solUtil(dp,nums,multipliers,n,mIndex+1,nIndex);
        
        return dp[mIndex][nIndex]=Math.max(takeFirst,takeLast);
    }
}