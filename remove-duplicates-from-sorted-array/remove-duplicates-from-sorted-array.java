class Solution {
    public int removeDuplicates(int[] nums) {
       
       int ptr=0;
       nums[ptr++]=nums[0];
        
       for(int i=1;i<nums.length;i++){
           
           if(i>0 && nums[i]!=nums[i-1]){
               nums[ptr]=nums[i];
               ptr++;
           }
       }
        
       return ptr; 
    }
}