class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int len=nums.length;
        int ans=0;
        
        long min=Integer.MAX_VALUE;
        long sum=0;
        long leftSum=0;
        long rightSum=0;
        
        for(int num:nums){
            sum+=num;
        }
        
        for(int i=0;i<len;i++){
            
            leftSum+=nums[i];
            rightSum=sum - leftSum;
            
            long diff=Math.abs(leftSum/(i+1) - (len - i == 1 ? 0 : rightSum/(len-i-1)));
            
            if(diff < min){
                min=diff;
                ans=i;
            }
        }
        
        return ans;
    }
}