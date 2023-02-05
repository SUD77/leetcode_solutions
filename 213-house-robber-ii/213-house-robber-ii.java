class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        
        int[] dp2=new int[nums.length];
        Arrays.fill(dp2,-1);
        
        int n=nums.length;
        
        return Math.max(solUtil(nums,n-1,1,dp),solUtil(nums,n-2,0,dp2));
    }
    
    public int solUtil(int[] nums,int start,int end,int[] dp){
        
       
        if(start==end) return dp[start]=nums[end];
        if(start<end) return 0;
        
        if(dp[start]!=-1) return dp[start];
        
        int pick=nums[start] + solUtil(nums,start-2,end,dp);
        int notPick=solUtil(nums,start-1,end,dp);
        
        return dp[start]=Math.max(pick,notPick);
    }
}