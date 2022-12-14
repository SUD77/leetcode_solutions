class Solution {
    public int rob(int[] nums) {
        
        int[] dp=new int[nums.length+1];
        
        Arrays.fill(dp,-1);
        
        return solUtil(nums,nums.length-1,dp);
    }
    
    private int solUtil(int[] nums,int i,int[] dp){
        
        if(i<0) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        return dp[i]=Math.max(solUtil(nums,i-2,dp) + nums[i], solUtil(nums,i-1,dp));
    }
}