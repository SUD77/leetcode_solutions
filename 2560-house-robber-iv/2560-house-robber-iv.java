// https://www.youtube.com/watch?v=ThaEDl4e3zs

class Solution {
    public int minCapability(int[] nums, int k) {
        
        int left=1;
        int right= (int)1e9;
        
        while(left < right) {
            
            int mid=( left + right ) >> 1;
            
            if(isPossible(mid,nums,k))
                right=mid;
            else
                left=mid+1;
        }
        
        return left;
    }
    
    public boolean isPossible(int mid,int[] nums,int k){
        
        int lastStealIndex=-2; // cant have -1 
        int houseRobbed=0;
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] > mid) continue;
            if(i == lastStealIndex + 1) continue;
            
            houseRobbed++;
            lastStealIndex=i;
        }
        
        return (houseRobbed >= k);
        
    }
}