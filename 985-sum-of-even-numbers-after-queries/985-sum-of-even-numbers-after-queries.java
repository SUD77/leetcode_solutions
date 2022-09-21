class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       
        int n=nums.length;
        int q=queries.length;
        
        int[] result=new int[q];
        int i=0;
        
        int currSum=sumOfEven(nums);
        
        for(int[] x:queries){
            
            int inital=nums[x[1]];
            
            if(inital%2==0){
                currSum -=inital;
            }
            
            nums[x[1]]=nums[x[1]]+x[0];
            
            int finalV=nums[x[1]];
            
            if(finalV%2==0){
                currSum+=finalV;
            }
            result[i++]=currSum;
        }
        
        return result;
        
    }
    
    public int sumOfEven(int[] nums){
        
        int resultSum=0;
        
        for(int x:nums){
            if(x%2==0){
                resultSum+=x;
            }
        }
        
        return resultSum;
    }
}