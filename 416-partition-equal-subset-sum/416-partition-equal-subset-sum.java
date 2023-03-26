class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        
        for(int x:nums){
            sum+=x;    
        }
        
        //if its odd, return false
        if(sum%2!=0){
            return false;
        }
        
        int target=sum/2;
        int n=nums.length;
        
        int[][] dp=new int[n][target+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);    
        }
        
        
        int ans=solUtil(nums,n-1,target,dp);
        
        if(ans==1) return true;
        return false;
    }
    
    public int solUtil(int[] nums,int index,int target,int[][] dp){
        
        if(dp[index][target]!=-1) return dp[index][target];
        
        if(target==0) return 1;
        
        if(index==0){
            if(target-nums[index]==0) return 1;
            else return 0;
        }
        
        

        
        int notPick=solUtil(nums,index-1,target,dp);
        
        int pick=0;
        
        if(target>=nums[index]) 
            pick=solUtil(nums,index-1,target-nums[index],dp);
  
        
        if(pick==0 && notPick==0){
            dp[index][target]=0;
        }else{
            dp[index][target]=1;
        }
        return dp[index][target];
    }
}