class Solution {
    
    public int jump(int[] nums) {
    
        int[] dp=new int[nums.length];
        
        Arrays.fill(dp,-1);
        
        return solUtil(nums,0,dp);
    }
    
    public int solUtil(int[] nums,int index,int[] dp){
        
        if(index>=nums.length-1) return 0;
        
        if(dp[index]!=-1) return dp[index];
            
        int minSteps=nums.length;
        
        for(int i=index+nums[index];i>=index+1;i--){
            
            minSteps=Math.min(minSteps,1+solUtil(nums,i,dp));
        }
        
        return dp[index]=minSteps;
    }
    
    
}