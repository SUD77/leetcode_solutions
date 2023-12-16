class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        
        List<Integer> temp=new ArrayList<>();
        
        solUtil(0,candidates,target,temp,res);

        return res;
    }
    
    
    public void solUtil(int index,int[] candidates,int target,List<Integer> temp,List<List<Integer>> res){
        
        if(index==candidates.length)
        {
            if(target==0){
                List<Integer> dummy=new ArrayList<>(temp);
                //System.out.println("1" + temp);
                res.add(dummy);
                
            }
            
            return;
        }
        
        if(target==0){
            List<Integer> dummy=new ArrayList<>(temp);
            //System.out.println("2: " + temp);
            res.add(dummy);
            return;
        }
        
        
        
        
        if(target-candidates[index]>=0){
            temp.add(candidates[index]);
            solUtil(index,candidates,target-candidates[index],temp,res);
            temp.remove(temp.size()-1);
        }
        
        solUtil(index+1,candidates,target,temp,res);
        
    }
}