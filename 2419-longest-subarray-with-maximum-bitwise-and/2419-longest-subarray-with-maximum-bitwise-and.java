class Solution {
    public int longestSubarray(int[] nums) {
     
        
        int n=nums.length;
        int maxElement=0;
        
        for(int x:nums){
            maxElement=Math.max(maxElement,x);
        }
        
        int ans=1;
        
        for(int i=0;i<n;i++){
            
            if(nums[i]==maxElement){
                
                int count=1;
                
                while(i+1<n && nums[i+1]==maxElement){
                    count++;
                    i++;
                }
                ans=Math.max(ans,count);
            }
        }
        
        return ans;
    }
}