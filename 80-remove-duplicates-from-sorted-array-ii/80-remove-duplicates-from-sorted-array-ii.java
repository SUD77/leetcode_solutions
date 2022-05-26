class Solution {
    public int removeDuplicates(int[] nums) {
        
         int i=0;
       int j=0;
       int count=1;

       while(i<nums.length-1){


           if(nums[i]!=nums[i+1]){
               count++;
               if(count>=2){

                   j++;
                   nums[j]=nums[i+1];
                   i++;
                   count=1;
               }else{
                   j++;
                   nums[j]=nums[i+1];
                   i++;
                   count=1;
               }
           }else{
               count++;
               if(count==2){
                   j++;
                   nums[j]=nums[i];
               }

               i++;
           }

       }


       return j+1;
    }
}