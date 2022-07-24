class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int n=nums.length;
        
        return solUtil(nums,target,n-1,0);
    }
    
    public int solUtil(int[] nums,int target,int index,int CurrSum){
        
//         if(index==0) {
         
//             if(nums[0]-target==0 || nums[0]+target==0) return 1;
//             else return 0;
//         }
        
        
        if(index==0) {
         
            
            if(nums[0]+CurrSum==target || CurrSum-nums[0]==target) {
                //System.out.println(index + " " + CurrSum);
                if(nums[0]==0) return 2;
                return 1;
            }
            else return 0;
        }
        
        
        //if(target==0) return 1;
        
        int add=solUtil(nums,target,index-1,CurrSum+nums[index]);
        
        int sub=solUtil(nums,target,index-1,CurrSum-nums[index]);
        
        
        return add+sub;
    }
}