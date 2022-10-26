class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> ans= new HashSet<>();     
        
        
        solUtil(nums,ans,0);
        
        List<List<Integer>> res= new ArrayList<>(); 
        
        for(List<Integer> x:ans){
            res.add(x);
        }
        
        return res;
    }
    
    public void solUtil(int[] nums,Set<List<Integer>> ans,int index){
        
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