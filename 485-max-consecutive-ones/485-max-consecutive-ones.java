class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int right=0;
        int count=0;
        int maxLength=0;
        
        while(right<nums.length){
            
             if(nums[right]==1){
                count++;
                maxLength=Math.max(count,maxLength);
            }else{
                maxLength=Math.max(count,maxLength);
                count=0;
            }
            right++;
        }
        
        return maxLength;
    }
}