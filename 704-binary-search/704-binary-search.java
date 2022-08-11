class Solution {
    public int search(int[] nums, int target) {
        
    
        return bs(nums,target,0,nums.length-1);
    }
    
    public int bs(int[] nums,int target,int startI,int endI){
        
        if(startI>endI) return -1;
        
        int mid= (startI+endI)/2;
        
        if(nums[mid]==target) return mid; 
        
        if(nums[mid]>target){
            return bs(nums,target,startI,mid-1);
        }else if(nums[mid]<target){
            return bs(nums,target,mid+1,endI);
        }
        
        return -1;
        
    }
}