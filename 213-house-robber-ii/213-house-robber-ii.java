class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        
        int[] dp2=new int[nums.length];
        Arrays.fill(dp2,-1);
        
        int n=nums.length;
        
        solUtil(nums,n-1,1,dp);
        
        //System.out.println(Arrays.toString(dp));
        
        solUtil(nums,n-2,0,dp2);
        
        //System.out.println(Arrays.toString(dp));
        
        int maxV=Integer.MIN_VALUE;
        
        for(int x:dp){
            maxV=Math.max(maxV,x);
        }
        
        for(int x:dp2){
            maxV=Math.max(maxV,x);
        }
        
        return maxV;
    }
    
    public int solUtil(int[] nums,int start,int end,int[] dp){
        
       
        if(start==end) return dp[start]=nums[end];
        if(start<end) return 0;
        
        if(dp[start]!=-1) return dp[start];
        
        //System.out.println(start);
        
        int pick=nums[start] + solUtil(nums,start-2,end,dp);
        int notPick=solUtil(nums,start-1,end,dp);
        
        //System.out.println(pick);
        return dp[start]=Math.max(pick,notPick);
    }
}