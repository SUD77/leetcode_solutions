class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result=new ArrayList<>();
        solUtil(candidates,target,0,new ArrayList<>(), result);
        
        return result;
    }
    
    public void solUtil(int[] candidates,int target,int CurrentIndex,List<Integer> CurrentSubset,List<List<Integer>> result ){
        
        if(CurrentIndex==candidates.length){
            return;
        }
        
        int sum=0;
        
        for(Integer x:CurrentSubset){
            sum+=x;
        }
        
        if(sum>target) return;
        if(sum==target){
            
            result.add(new ArrayList(CurrentSubset));
            return;
        }
        
        
        CurrentSubset.add(candidates[CurrentIndex]);
        solUtil(candidates,target,CurrentIndex,CurrentSubset,result);
        
        CurrentSubset.remove(CurrentSubset.size()-1);
        solUtil(candidates,target,CurrentIndex+1,CurrentSubset,result);
        
        
    }
}