// https://www.youtube.com/watch?v=NZh-HcLXQ_g

class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int ans=0;
        
        for(int i=0;i<32;i++){
            
            int count1=0;
            int count0=0;
            
            for(int j=0;j<nums.length;j++){
                
                if(((1<<i) & nums[j])==0) count0++;
                else count1++;
            }
            
            ans+=count1*count0;
        }
        
        return ans;
    }
}