// Check striver's video : https://www.youtube.com/watch?v=PzszoiY5XMQ&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65

/*

Havent implemented the same code as in video, but logic of right and left instance is same. He has impelemented XOR for that, we have done directly. 
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int left =0 ;
        int right = nums.length -1;
        
        while( left < right){
            
            int mid = (left + right) / 2;
            
            if((mid%2==0 && nums[mid]==nums[mid+1]) || 
               (mid%2==1 && nums[mid]==nums[mid-1])){
                left=mid+1;
            } else {
                right=mid;
            }
        }
        
        
        return nums[left];
    }
}