class Solution {
    public int[] runningSum(int[] nums) {
        
//         int[] result=new int[nums.length];
        
//         int k=0;
//         int j=0;
        
//         while(k<nums.length){
//             int sum=0;
//             for(int i=0;i<=k;i++){
//                 sum+=nums[i];
//             }
//             result[j++]=sum;
//             k++;
//         }
        
//         return result;
        
        for(int i=1;i<nums.length;i++){
            nums[i] +=nums[i-1];
        }
        
        return nums;
    }
}