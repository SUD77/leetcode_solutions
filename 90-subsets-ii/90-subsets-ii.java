class Solution {
    
    Set<List<Integer>> result2=new HashSet<>();
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        subsetUtil(nums,0,new ArrayList());
        
        for(List<Integer> x:result2){
            result.add(x);
        }

        return result;
    }
    
    public void subsetUtil(int[] nums,int currentIndex,List<Integer> currentSubset){

        if(currentIndex==nums.length){

            result2.add(new ArrayList(currentSubset));
//            result.add(new ArrayList(currentSubset));

            return;
        }

        currentSubset.add(nums[currentIndex]);
        subsetUtil(nums,currentIndex+1,currentSubset);

        currentSubset.remove(currentSubset.size()-1);
        subsetUtil(nums,currentIndex+1,currentSubset);
    }
    
    
}