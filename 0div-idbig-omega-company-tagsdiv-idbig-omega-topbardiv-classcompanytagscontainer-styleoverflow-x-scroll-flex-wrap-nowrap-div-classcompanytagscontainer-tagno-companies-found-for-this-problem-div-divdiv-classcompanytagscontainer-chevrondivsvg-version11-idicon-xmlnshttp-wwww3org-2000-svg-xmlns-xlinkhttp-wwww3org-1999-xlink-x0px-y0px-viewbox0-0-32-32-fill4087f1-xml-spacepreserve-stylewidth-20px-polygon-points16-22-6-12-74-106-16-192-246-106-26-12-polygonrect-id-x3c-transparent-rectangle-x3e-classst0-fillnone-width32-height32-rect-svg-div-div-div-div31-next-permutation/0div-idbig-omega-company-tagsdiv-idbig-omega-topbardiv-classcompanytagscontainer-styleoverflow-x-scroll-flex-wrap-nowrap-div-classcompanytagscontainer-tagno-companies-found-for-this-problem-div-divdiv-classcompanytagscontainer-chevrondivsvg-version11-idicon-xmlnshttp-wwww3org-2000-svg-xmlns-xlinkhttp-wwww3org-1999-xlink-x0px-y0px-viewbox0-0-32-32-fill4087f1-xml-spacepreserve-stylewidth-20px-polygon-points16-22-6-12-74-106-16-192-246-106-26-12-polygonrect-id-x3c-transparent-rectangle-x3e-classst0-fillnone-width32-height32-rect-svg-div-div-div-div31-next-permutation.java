class Solution {
    public void nextPermutation(int[] nums) {
         //find peak mountain breaking index
        int n=nums.length;
        int i=n-2;
        
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        //swap numbers at i and last index
        if(i!=-1){
            
             //1. find FIRST GREATER element than a[i] starting from back
            int j=n-1;
            
            while(j>i && nums[j]<=nums[i]) j--;
            
            //2. swap the prev  i.e i, justGreater   
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        
        //sort everything from i+1
        reverse(i+1, nums);
        
    }
    
    public void reverse(int ind, int[] nums){
        
        int i=ind;
        int j=nums.length-1;
        
        while(i<j){
            
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            
            i++;
            j--;
        }
    }
}