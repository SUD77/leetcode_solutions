class Solution {
    public List<List<Integer>> permute(int[] nums) {
     
        
        List<List<Integer>> ans= new ArrayList<>();     
        
        solUtil(nums,ans,0);
        
        return ans;
    }
    
    public void solUtil(int[] nums,List<List<Integer>> ans,int index){
        
        if(index==nums.length){
            
            List<Integer> tempDs=new ArrayList<>();
            
            for(int x:nums){
                tempDs.add(x);    
            }
            
            ans.add(tempDs);
            return;
        }
        
       for(int i=index;i<nums.length;i++){
           
           swapMe(nums,i,index);
           solUtil(nums,ans,index+1);
           swapMe(nums,index,i);
       }
    }
    
    public void swapMe(int[] nums,int i,int j){
        
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        
    }
}
