//Space Optimization

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[] prev=new int[n+1];
        
        
        for(int index=n-1;index>=0;index--){
            
            int[] curr=new int[n+1];
            
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                
                int notPick=prev[prevIndex+1]; 
        
                int pick=0;
                if(prevIndex==-1){
                    pick=1+prev[index+1]; 
                }else if(nums[index]>nums[prevIndex]){
                    pick=1+prev[index+1]; 
                }

                curr[prevIndex+1]=Math.max(pick,notPick);
            }
            
            prev=curr;
        }
                
        return prev[0]; 
    }
    
}