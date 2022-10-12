class Solution {
    
    int sum=0;
    
    public int subsetXORSum(int[] nums) {
        
        return solUtil(nums,0,0);
    
    }
    
    int solUtil(int[] arr,int i,int curr){
        
        if(i==arr.length){
            return curr;
        }
        
        return solUtil(arr,i+1,curr^arr[i]) + solUtil(arr,i+1,curr);
    }
}