class Solution {
    public List<List<Integer>> combinationSum2(int[] A, int val) {
        
        //Sorting the array so that to avoid duplicates 
        Arrays.sort(A);
		List<List<Integer>> result=new ArrayList<>();
        combiUtil(A,val,0,new ArrayList(),result);

        return result;
    }
    
    public static void combiUtil(int[] A,int remain, int start, List<Integer> currentSubset, List<List<Integer>> result){

        if(remain<0) return;
        
        if(remain==0) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        
        for(int i=start;i<A.length;i++){
            if(i>start && A[i]==A[i-1]) continue;
            currentSubset.add(A[i]);
            combiUtil(A,remain-A[i],i+1,currentSubset,result);
            currentSubset.remove(currentSubset.size()-1);    
        }
        
    }
}