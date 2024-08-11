class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> tempAns=new HashSet<>();
        
        solUtil(0,nums,tempAns,new ArrayList<>());
        
        return new ArrayList<>(tempAns);
    }
    
    public void solUtil(int i, int[] nums, Set<List<Integer>> tempAns,List<Integer> list){
        
        if(i==nums.length){
            tempAns.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[i]);
        solUtil(i+1,nums,tempAns,list);
        list.remove(list.indexOf(nums[i]));
        solUtil(i+1,nums,tempAns,list);
    }
}