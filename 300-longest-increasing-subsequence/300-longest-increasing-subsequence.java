class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(nums,-1,0,dp);
    }
    
    public int solUtil(int[] nums,int prevIndex,int nextIndex,int[][] dp){
        
        if(nextIndex==nums.length){
            return 0;
        }
        
        if(dp[prevIndex+1][nextIndex]!=-1) return dp[prevIndex+1][nextIndex]; 
        
        
        int notTake=solUtil(nums,prevIndex,nextIndex+1,dp);
        
        int take=0;
        
        if(prevIndex==-1){
            take=1+solUtil(nums,nextIndex,nextIndex+1,dp);
        }else if(nums[nextIndex]>nums[prevIndex]){
            take=1+solUtil(nums,nextIndex,nextIndex+1,dp);
        }
           
            
        return dp[prevIndex+1][nextIndex]=Math.max(take,notTake);    
         
        
    }
}