class Solution {
    
    public boolean canJump(int[] nums) {
        
        int[] dp=new int[nums.length];
        
        return solUtil(nums,0,dp);
    }
    
    public boolean solUtil(int[] nums,int index,int[] dp){
        
        if(index==nums.length-1) return true;

        if(index>=nums.length || nums[index]==0 || dp[index]==-1) return false;
        
        if(dp[index]==1) return true;
 
        for(int i=index+nums[index];i>=index+1;i--)
        {
            
            if(solUtil(nums,i,dp)){
                dp[index]=1;
                return true;
            }
                
        }
        
        dp[index]=-1;
        return false; 
        
        
    }
}