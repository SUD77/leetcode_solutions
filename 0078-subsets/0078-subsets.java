class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        solUtil(0,nums,temp,ans);
        
        return ans;
    }
    
    public void solUtil(int index,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        
        if(index==nums.length){
            List<Integer> dummy=new ArrayList<>(temp);
            ans.add(dummy);
            return;
        }
        
        temp.add(nums[index]);
        solUtil(index+1,nums,temp,ans);
        
        temp.remove(temp.size()-1);
        solUtil(index+1,nums,temp,ans);
    }
}