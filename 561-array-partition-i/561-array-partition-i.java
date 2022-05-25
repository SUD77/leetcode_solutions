class Solution {
    public int arrayPairSum(int[] nums) {
        
        int sum=0;

        /* Logic : We will sort the array, so as to select the highest min. (Think of adjacent 
        elements).  
        */
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i=i+2){
            sum=sum+Math.min(nums[i],nums[i+1]);
        }

        return sum;
    }
}