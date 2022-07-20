class Solution {
    public boolean canPartition(int[] nums) {
        
        
        int sum=0;
        
        for(int x:nums){
            sum+=x;    
        }
        
        if(sum%2!=0) return false;
        sum=sum/2;
        
        
        
        //dp. 
        int dp[][]=new int[nums.length][sum+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
      
        int ans=solUtil(nums.length-1,sum,nums,dp);
        
        if(ans==1) return true;
        
        return false;
    }
    
    public int solUtil(int index,int target,int[] arr,int[][] dp){
        
        if(dp[index][target]!=-1) return dp[index][target];
        
        if(target==0) return 1;
        if(index==0){
            
            if(arr[0]==target) return 1;
            else return 0;
        } 
            
        
        int notTake=solUtil(index-1,target,arr,dp);
        
        int take=0;
        if(target>=arr[index]){
            take=solUtil(index-1,target-arr[index],arr,dp);
        }
        
        if(take==0 && notTake==0){
            dp[index][target]=0;
        }else{
            dp[index][target]=1;
        }
        
        return dp[index][target];
        
    }
}