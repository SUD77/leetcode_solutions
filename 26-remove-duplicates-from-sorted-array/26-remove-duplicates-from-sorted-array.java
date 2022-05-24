class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int i=0;
        int j=0;
        int size=nums.length;

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