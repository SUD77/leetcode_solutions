class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        
       
       
        
        int totalSum=0;
        
        for(int x:nums){
            totalSum+=x;
        }
        
        if(totalSum-target<0) return 0;
        
        //newTarget can't be odd, so if this diff is not divisible by 2, return 0;
        if((totalSum-target)%2==1) return 0;
        int newTarget=(totalSum-target)/2;
        
        //Making dp  array with newTarget
        
         int dp[][]=new int[n][newTarget+1];
        
        for(int[] x:dp){
             Arrays.fill(x,-1);
        }
        
        
        
        return solUtil(n-1,nums,newTarget,dp);
    }
    
    public int solUtil(int index,int[] nums,int target,int[][] dp){
 
        if(index==0){
            
            if(target==0 && nums[0]==0) return 2;
            
            if(target==0 | target==nums[0]) return 1;
            
            return 0;
        }
        
         if(dp[index][target]!=-1) return dp[index][target];
        
        int notTaken=solUtil(index-1,nums,target,dp);
        
        int taken=0;
        
        if(nums[index]<=target){
            taken=solUtil(index-1,nums,target-nums[index],dp);
        }
        
        return dp[index][target]=taken+notTaken;
    }
}