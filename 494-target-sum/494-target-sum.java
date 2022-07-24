class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        
        int totalSum=0;
        
        for(int x:nums){
            totalSum+=x;
        }
        
        if(totalSum-target<0) return 0;
        
        //newTarget can't be odd, so if this diff is not divisible by 2, return 0;
        if((totalSum-target)%2==1) return 0;
        
        int newTarget=(totalSum-target)/2;
        
        return solUtil(n-1,nums,newTarget);
    }
    
    public int solUtil(int index,int[] nums,int target){
        
        if(index==0){
            
            if(target==0 && nums[0]==0) return 2;
            
            if(target==0 | target==nums[0]) return 1;
            
            return 0;
        }
        
        int notTaken=solUtil(index-1,nums,target);
        
        int taken=0;
        
        if(nums[index]<=target){
            taken=solUtil(index-1,nums,target-nums[index]);
        }
        
        return taken+notTaken;
    }
}