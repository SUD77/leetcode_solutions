//Not my code and logic

class Solution {
    public int search(int[] arr, int target) {
        
        
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            
            int mid=(low+high)>>1;
            
            if(arr[mid]==target)
                return mid;
            
            //this if else check if left half is sorted or right
            if(arr[low]<=arr[mid]){
                
                if(arr[low]<=target && arr[mid]>=target)
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                if(arr[mid]<=target && target<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        
        return -1;
    }
}