class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        solUtil(candidates,target,0,new ArrayList(),result);
        
        return result;
    }
    
    public void solUtil(int[] A,int remain,int start,List<Integer> currentSubset, List<List<Integer>> result){
        
        if(remain<0) return;
        
        if(remain==0){
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        
        for(int i=start; i<A.length;i++){
            
            if(i>start && A[i]==A[i-1] ) continue;
            currentSubset.add(A[i]);
            solUtil(A,remain-A[i],i+1,currentSubset,result);
            currentSubset.remove(currentSubset.size()-1);
        }
    }
}