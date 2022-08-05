class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int n=nums.length;
        
        int[][] dp=new int[n][target+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        //System.out.println(result);
        return solUtil(nums,target,0,dp);
    }
    
    
     public int solUtil(int[] nums,int target,int index,int[][] dp){
        
       
       
         if(target==0) return 1;
         if(index==nums.length) return 0;
         
         if(dp[index][target]!=-1) return dp[index][target]; 
         
        int notTake=solUtil(nums,target,index+1,dp);
        int take=0;
        if(target>=nums[index]){
            take=solUtil(nums,target-nums[index],0,dp);
        }
             
        
        
     
        return dp[index][target]=take+notTake;   
        
    }
}