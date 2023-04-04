

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[][] dp=new int[n][n];
        
        
        for(int[] x:dp){
            Arrays.fill(x,Integer.MIN_VALUE);
        }
                
        return solUtil(nums,-1,0,dp);
    }
    
    public int solUtil(int[] nums,int prevIndex,int index,int[][] dp){
        
        if(index==nums.length) return 0;
        
        if(dp[prevIndex+1][index]!=Integer.MIN_VALUE) return dp[prevIndex+1][index];
        
        int notPick=solUtil(nums,prevIndex,index+1,dp);
        
        int pick=0;
        if(prevIndex==-1){
            pick=1+solUtil(nums,index,index+1,dp);
        }else if(nums[index]>nums[prevIndex]){
            pick=1+solUtil(nums,index,index+1,dp);
        }
        
        return dp[prevIndex+1][index]=Math.max(pick,notPick);
        
    }
}