class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        int n=nums.length;
        
        
        return solUtil(nums,n);
    }
    
    public long solUtil(int[] nums,int n){
        
        
        long result=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                
                long counter=1;
                int k=i+1;
                while(k<n && nums[k]==0){
                    counter++;
                    k++;
                }
                
                //to check no of subarrays formed
                long temp=(counter * (counter+1))/2;
                result+=temp;
                
                i=k-1;
            }
            
        }
        
        return result;
        
    }
}