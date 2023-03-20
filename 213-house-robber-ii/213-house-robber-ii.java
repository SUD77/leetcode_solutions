class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int n=nums.length;
        
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        
        // dp1[1]=nums[1];
        // dp2[0]=nums[0];
        
        for(int start=1;start<=n-1;start++){
            
            if(start==1) dp1[start]=nums[start];
            else{
                int pick=nums[start];
                
                if(start>1) pick+=dp1[start-2];
                int notPick=dp1[start-1];
           
                 dp1[start]=Math.max(pick,notPick);
            }
            
         
        }
        
        
        for(int start=0;start<=n-2;start++){
            
            if(start==0) dp2[start]=nums[start];
            else{
                int pick=nums[start];
                
                if(start-2>=0) pick+=dp2[start-2];
                int notPick=dp2[start-1];
           
                 dp2[start]=Math.max(pick,notPick);
            }
            
         
        }
        
        return Math.max(dp1[n-1],dp2[n-2]);
    }
    
//     public int solUtil(int start,int end,int[] nums,int[] dp){
        
//         if(start==end) return nums[end];
        
//         if(start<end) return 0;
        
//         if(dp[start]!=-1) return dp[start];
        
//         int pick=nums[start] + solUtil(start-2,end,nums,dp);
//         int notPick=solUtil(start-1,end,nums,dp);
        
//         return dp[start]=Math.max(pick,notPick);
//     }
}