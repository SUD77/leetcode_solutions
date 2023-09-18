class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        
        int[] dp=new int[n];
        
        Arrays.fill(dp,-1);
        
        return solUtil(0,nums,dp);
    }
    
    public int solUtil(int index,int[] nums,int[] dp){
        
        if(index>=nums.length){
            return 0;
        }
        
        if(dp[index]!=-1) return dp[index];
        
        int pick=0;
        if(index<nums.length)
         pick=nums[index] + solUtil(index+2,nums,dp);
        
        int notPick=solUtil(index+1,nums,dp);
        
        return dp[index]=Math.max(pick,notPick);
    }
}