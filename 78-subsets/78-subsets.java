class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        solUtil(nums,0,new ArrayList<>(),result);
        
        return result;
    }
    
    public void solUtil(int[] nums,int currentIndex,ArrayList<Integer> currentSubset,List<List<Integer>> result){
        
        if(currentIndex==nums.length){
            result.add(new ArrayList(currentSubset));
            
            return;
        }
        
        currentSubset.add(nums[currentIndex]);
        solUtil(nums,currentIndex+1,currentSubset,result);
        
        currentSubset.remove(currentSubset.size()-1);
        solUtil(nums,currentIndex+1,currentSubset,result);
    }
}