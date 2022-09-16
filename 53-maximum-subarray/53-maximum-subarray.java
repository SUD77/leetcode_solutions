class Solution {
    public int maxSubArray(int[] nums) {
        
        int finalResult=Integer.MIN_VALUE;
        int maxSum=0;
        
        for(int i=0;i<nums.length;i++){
            
            if(maxSum<0) maxSum=0;
            maxSum+=nums[i];
            
            
            finalResult=Math.max(maxSum,finalResult);
        }
        
        
        return finalResult;
    }
}