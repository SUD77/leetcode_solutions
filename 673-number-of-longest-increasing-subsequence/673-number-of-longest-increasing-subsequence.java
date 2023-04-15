class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[] dp=new int[n];
        int[] count=new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        
        int maxi=1;
        
        for(int index=0;index<n;index++){
            
            for(int prev=0;prev<index;prev++){
                
                if(nums[prev]<nums[index] && 1+dp[prev] > dp[index]){
                    dp[index]=1+dp[prev];
                    count[index]=count[prev];
                }else if(nums[prev] < nums[index] && 1+dp[prev]==dp[index]){
                    count[index]+=count[prev];
                }
            }
            
            maxi=Math.max(maxi,dp[index]);
        }
        
        int result=0;
        
        for(int i=0;i<n;i++){
            if(dp[i]==maxi) result+=count[i]; 
        }
        
        return result;
    }
}