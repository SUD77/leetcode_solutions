class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int n=nums.length;
        
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        return Math.max(solUtil(n-1,1,nums,dp1),solUtil(n-2,0,nums,dp2));
    }
    
    public int solUtil(int start,int end,int[] nums,int[] dp){
        
        if(start==end) return nums[end];
        
        if(start<end) return 0;
        
        if(dp[start]!=-1) return dp[start];
        
        int pick=nums[start] + solUtil(start-2,end,nums,dp);
        int notPick=solUtil(start-1,end,nums,dp);
        
        return dp[start]=Math.max(pick,notPick);
    }
}