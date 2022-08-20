//NOt my logic and code

class Solution {
    public int specialArray(int[] nums) {
        
        Arrays.sort(nums);
        
        int len=nums.length;
        int left=0;
        int right=len-1;
        
        while(left<=right){
            
            int mid=left + (right - left)/2;
            
            if(nums[mid] >= len-mid){
                
                if(mid==0 || nums[mid - 1] < len-mid){
                    return len-mid;
                }else{
                    right=mid-1;
                }
            }else{
                left=mid+1;
            }
        }
        
        return -1;
    }
}