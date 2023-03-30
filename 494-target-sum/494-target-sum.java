class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        
        int totalSum=0;
        
        for(int x:nums){
            totalSum+=x;
        }
        
        if(totalSum-target < 0 ) return 0;
        
        //newTarget can't be odd, so if this diff is not divisible by 2, return 0;
        if((totalSum-target)%2!=0) return 0;
        
        int newTarget=(totalSum-target)/2;
        
        int[][] dp=new int[n][newTarget+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(nums,newTarget,n-1,dp);
    }
    
    public int solUtil(int[] nums,int target,int index,int[][] dp){
        
        if(index==0){
            
            if(target==0 && nums[0]==0) return 2;
            else if(target==0 || target==nums[0]) return 1;
            else return 0;
        }
        
        if(dp[index][target]!=-1) return dp[index][target]; 
        
        int notPick=solUtil(nums,target,index-1,dp);
        
        int pick=0;
        if(target>=nums[index]){
            pick=solUtil(nums,target-nums[index],index-1,dp);
        }
        
        return dp[index][target]=pick+notPick;
        
    }
}