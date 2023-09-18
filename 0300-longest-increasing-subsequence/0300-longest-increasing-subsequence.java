class Solution {
    public int lengthOfLIS(int[] nums) {
            
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        
        int prev=-1;
        
        return solUtil(0,nums,prev,dp);
        
    }
    
    public int solUtil(int index,int[] nums,int prev,int[][] dp){
        
        if(index==nums.length){
            return 0;
        }
        
        if(dp[index][prev+1]!=-1) return dp[index][prev+1]; 
        
        int pick=Integer.MIN_VALUE;
        
        if(prev==-1 || nums[index]>nums[prev])
            pick=1+solUtil(index+1,nums,index,dp);
        
        int notPick=solUtil(index+1,nums,prev,dp);
        
        return dp[index][prev+1]=Math.max(pick,notPick);
    }
}