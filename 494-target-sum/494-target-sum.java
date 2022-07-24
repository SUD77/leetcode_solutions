class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int n=nums.length;
        
        return solUtil(nums,target,n-1);
    }
    
    public int solUtil(int[] nums,int target,int index){
        
        if(index==0) {
         
            if(target-nums[0]==0 || nums[0]+target==0) {
                if(nums[0]==0) return 2;
                return 1;
            }
            else return 0;
        }
 
        
        int add=solUtil(nums,target+nums[index],index-1);
        
        int sub=solUtil(nums,target-nums[index],index-1);
        
        
        return add+sub;
    }
}