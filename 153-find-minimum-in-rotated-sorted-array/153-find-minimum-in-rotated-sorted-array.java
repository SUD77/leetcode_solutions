class Solution {
    public int findMin(int[] nums) {
       
        int n=nums.length;
        int low=-1;
        int high=n-1;
        
        while(low+1<high){
            
            int mid=low + (high - low)/2;
            
            if(isLess(mid,nums)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        return nums[high];
    }
    
    public boolean isLess(int mid,int[] nums){
        return nums[mid]<=nums[nums.length-1];
    }
}