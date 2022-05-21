class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int size=nums.length;
        
        //Final answer. 
        int[] result=new int[nums.length];
        
        int i=0;
        int j=size-1;
        
        /* Logic : Using two pointer logic. We will place i and j, at start and end of array. We will
        compare the absolute value at i and j, and then accordingly store them in result array. (this 
        is the logic of "if else" inside this for loop)
        */
        for (int p = size - 1; p >= 0; p--) {
            
            if(i>j) break;
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        
        return result;
    }
}