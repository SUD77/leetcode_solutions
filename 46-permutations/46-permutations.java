class Solution {
    public List<List<Integer>> permute(int[] nums) {
     
        
        List<List<Integer>> ans= new ArrayList<>();     
        List<Integer> tempDs=new ArrayList<>(); 
        boolean[] freq=new boolean[nums.length];
        
        solUtil(nums,ans,tempDs,freq);
        
        return ans;
    }
    
    public void solUtil(int[] nums,List<List<Integer>> ans,List<Integer> tempDs,boolean[] freq ){
        
        if(tempDs.size() == nums.length){
            ans.add(new ArrayList<>(tempDs));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(!freq[i]){
                tempDs.add(nums[i]);
                freq[i]=true;
                
                solUtil(nums,ans,tempDs,freq);
                
                tempDs.remove(tempDs.size()-1);
                freq[i]=false;
            }
            
        }
    }
}
