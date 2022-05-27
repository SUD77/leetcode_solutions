class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
      
        Arrays.sort(nums);
        int i=0;

        while(k>0){

            if(nums[i]<0){
                nums[i] = nums[i] * (-1);

                k--;
            }
            i++;

            if(i== nums.length) break;


        }

        Arrays.sort(nums);
        int min=nums[0];


        int sum=0;
        for(int x:nums){
            sum +=x;
        }

        if(k%2!=0){
            sum=sum-(2*min);
        }
        
        
        return sum;
    }
}