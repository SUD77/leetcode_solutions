//Different sol
// Mentioned in dp42 video from 10th min to 16th min

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        int maxAns=1;
        
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        for(int index=0;index<n;index++){
            
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                
               if(nums[prevIndex]<nums[index]){
                   dp[index]=Math.max(dp[index],1+dp[prevIndex]);
               }
            }
            maxAns=Math.max(maxAns,dp[index]);
            
        }
                
        return maxAns; 
    }
    
}