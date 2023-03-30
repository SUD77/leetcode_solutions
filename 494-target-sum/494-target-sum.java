class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        
        int totalSum=0;
        
        for(int x:nums){
            totalSum+=x;
        }
        
        if(totalSum-target < 0 ) return 0;
        
        //newTarget can't be odd, so if this diff is not divisible by 2, return 0;
        if((totalSum-target)%2!=0) return 0;
        
        int newTarget=(totalSum-target)/2;
        
        return solUtil(nums,newTarget,n-1);
    }
    
    public int solUtil(int[] nums,int target,int index){
        
        if(index==0){
            
            if(target==0 && nums[0]==0) return 2;
            else if(target==0 || target==nums[0]) return 1;
            else return 0;
        }
        
        int notPick=solUtil(nums,target,index-1);
        
        int pick=0;
        if(target>=nums[index]){
            pick=solUtil(nums,target-nums[index],index-1);
        }
        
        return pick+notPick;
        
    }
}