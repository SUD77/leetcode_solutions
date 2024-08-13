class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Set<List<Integer>> res=new HashSet<>();
        
        int n=candidates.length;
        
        solUtil(0,candidates,target,res,new ArrayList<>());
        
        return new ArrayList<>(res);
    }
    
    public void solUtil(int i,int[] candidates,int target, Set<List<Integer>> res,List<Integer> temp){
        
        if(i==candidates.length){
            
            if(target==0){
              res.add(new ArrayList<>(temp));
            }

            return;
        }
        
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;   
        }
     
        
        
        if(target-candidates[i]>=0){
            temp.add(candidates[i]);
            solUtil(i,candidates,target-candidates[i],res,temp);
            temp.remove(temp.size()-1);
        }
            
        solUtil(i+1,candidates,target,res,temp);
    }
}