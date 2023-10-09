class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurrance(nums,target);
        int last=lastOccurence(nums,target);
        
        return new int[]{first,last};
    }
    
    public int firstOccurrance(int[] nums,int target){
        
        int low=-1;
        int high=nums.length;
        
        while(low + 1 < high){
            
            int mid=low + (high - low)/2;
            
            if(isGreaterOrEqual(nums[mid],target)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        if(high==nums.length || nums[high]!=target){
            return -1;
        }
        
        return high;
    }
    
    /*low will converge the mid portion
    i.e low will shrink the portion by moving. 
    
    */
    public int lastOccurence(int[] nums,int target){
        
        int low=-1;
        int high=nums.length;
        
        while(low + 1 < high){
            
            int mid=low + (high - low)/2;
            
            if(isSmallerOrEqual(nums[mid],target)){
                low=mid;
            }else{
                high=mid;
            }
        }
        
        if(low==-1 || nums[low]!=target){
            return -1;
        }
        
        return low;
    }
    
    public boolean isGreaterOrEqual(int nums,int target){
        return nums>=target;
        
    }
    
    public boolean isSmallerOrEqual(int nums,int target){
        return nums<=target;
        
    }
    
    
}