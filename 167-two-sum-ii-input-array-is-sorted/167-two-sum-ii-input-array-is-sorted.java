class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result=new int[2];
        
        int i=0;
        int j=nums.length-1;
        
        while(i<j){
            
            if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                result[0]=i+1;
                result[1]=j+1;
                break;
            }
        }
        
        return result;
    }
}