class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        int result= Integer.MAX_VALUE;

        /* Using sliding window approach. We will use the window of k, and keep chekcing elements
        at the starign fo the k window and last of k window. If theri diff is minimum, than the 
        value stored in result, so result will assigned that min value. 
        */
        for(int i=0;i< nums.length;i++){
            if(i+k-1 >= nums.length) break;
            result=Math.min(result,nums[i+k-1]-nums[i]);
        }
        
        return result;
    }
}