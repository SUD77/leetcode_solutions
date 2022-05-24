class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int i=0;
        int j=0;
        int size=nums.length;

        /* Logic : Using two pointers. Basically, i iterates over the (length of array-1).  But j is only incremented when arr[i] and arr[i+1] are not equal. Then we assign that value(arr[i+1]) to arr[j] (but after incrementing j). That's how duplicates are removed.  
        */
        while(i<size-1){
            if(nums[i+1]==nums[i]){
                i++;
            }else{
                j++;
                nums[j]=nums[i+1];
                i++;
            }
        }
        
        
        return j+1;
    }
}