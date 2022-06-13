class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==1){
            return 1;
        }
        
        Arrays.sort(nums);

        int maxLength=0;
        int currLength=1;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]+1){
                currLength=1;


            }else{
                if(nums[i+1]==nums[i]){
                    currLength=currLength;
                }else{
                    currLength++;
                }
            }
            maxLength=Math.max(currLength,maxLength);
        }


        return maxLength;

    }
}