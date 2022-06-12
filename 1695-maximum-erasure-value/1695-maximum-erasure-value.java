class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        
        int left=0;
        int maxLength=0;
        int sum=0;
        int right=0;
        int intial=left;

        Map<Integer,Integer> temp=new HashMap<>();

        while(right<nums.length){

            if(temp.containsKey(nums[right])){
                left=Math.max(temp.get(nums[right])+1,left);
                while(intial<left){
                    sum-=nums[intial];
                    intial++;
                }
            }

            temp.put(nums[right],right);
            sum+=nums[right];
            maxLength=Math.max(sum,maxLength);
            right++;


        }

        return maxLength;
    }
}