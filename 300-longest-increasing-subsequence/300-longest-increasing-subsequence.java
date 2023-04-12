

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
        for(int index=n-1;index>=0;index--){
            
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                
                int notPick=dp[index+1][prevIndex+1]; 
        
                int pick=0;
                if(prevIndex==-1){
                    pick=1+dp[index+1][index+1]; 
                }else if(nums[index]>nums[prevIndex]){
                    pick=1+ dp[index+1][index+1]; 
                }

                dp[index][prevIndex+1]=Math.max(pick,notPick);
            }
        }
                
        return dp[0][0]; 
    }
    
}