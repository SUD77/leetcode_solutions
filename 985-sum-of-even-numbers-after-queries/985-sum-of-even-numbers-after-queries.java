class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
       
        
        int q=queries.length;
        
        int[] result=new int[q];
        int i=0;  
        
        
        //Calculting sum of even no. 
        int currSum=sumOfEven(nums);
        
        for(int[] x:queries){
            
            
            //Remove the curr no from CurrSum, if its even. 
            int inital=nums[x[1]];
            
            if(inital%2==0){
                currSum -=inital;
            }
            
            //Do the query process on curr no
            nums[x[1]]=nums[x[1]]+x[0];
            
            
            //Add the curr no in CurrSum if its even. 
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