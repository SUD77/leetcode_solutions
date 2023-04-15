/*
For explanation : https://www.youtube.com/watch?v=y4vN0WNdrlg
*/
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n=nums.length;
        int maxAns=1;
        
        int[] dp1=new int[n];
        Arrays.fill(dp1,1);

        int[] dp2=new int[n];
        Arrays.fill(dp2,1);
        
        //Filling from front
        for(int index=0;index<n;index++){
            
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                
               if(nums[prevIndex]<nums[index]){
                   dp1[index]=Math.max(dp1[index],1+dp1[prevIndex]);
               }
            }
            
        }


        //filling from back
        for(int index=n-1;index>=0;index--){
            
            for(int prevIndex=n-1;prevIndex>index;prevIndex--){
                
               if(nums[prevIndex]<nums[index]){
                   dp2[index]=Math.max(dp2[index],1+dp2[prevIndex]);
               }
            }
            
        }

        for(int i=0;i<n;i++){
            
            if(dp1[i]!=1 && dp2[i]!=1)
                maxAns=Math.max(maxAns,dp1[i]+dp2[i]-1);
        }
                
        return n-maxAns; 
        
    }
}