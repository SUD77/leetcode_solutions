class Solution {
    public int search(int[] nums, int target) {
        
        //Will use binary search for this too
        int minIndex=findMinIndex(nums);
        
        /*
        - Basically, we will check if target is less than last ele, 
        - if it is, than we do bs in minIndex to last ele
            - as, if is less than last ele, it is surely greater than minIndex
        - else, will do bs from 0 to minIndex
        
        */
        if(isLessThanRightMost(nums,target)){
            return binarySearch(nums,target,minIndex,nums.length-1);
        }else{
            return binarySearch(nums,target,0,minIndex);
        }
    }
    
    public boolean isLessThanRightMost(int[] nums,int target){
        return target<=nums[nums.length-1];
    }
    
    public int findMinIndex(int[] nums){
        
        int low=-1;
        int high=nums.length;
        
        while(low+1<high){
            
            int mid=low + (high-low)/2;
            
            if(isLessThanOrEqual(nums[mid],nums)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        return high;
    }
    
    public boolean isLessThanOrEqual(int ele,int[] nums){
        return ele<=nums[nums.length-1];
    }
    
    
    public int binarySearch(int[] arr,int target,int left,int right){
        
        int low=left-1;
        int high=right;
        
        while(low+1<high){
            
            int mid=low + (high - low)/2;
            
            if(isGreaterOrEqual(arr[mid],target)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        return arr[high]==target ? high:-1;
    }
    
    public boolean isGreaterOrEqual(int x,int y){
        return x>=y;
    }
}