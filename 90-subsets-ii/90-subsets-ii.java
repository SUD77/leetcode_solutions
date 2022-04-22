class Solution {
    public List<List<Integer>> subsetsWithDup(int[] A) {
        
        List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(A);
        subsetUtil(A,0,new ArrayList(),result);

        
        return result;
    }
    
    public void subsetUtil(int[] A,int currentIndex,List<Integer> currentSubset,List<List<Integer>> set){
		
		if(currentIndex==A.length){
            List<Integer> te=new ArrayList<>(currentSubset);
            List<Integer> te2=new ArrayList<>(currentSubset);
            Collections.sort(te);
            Collections.sort(te2,Collections.reverseOrder());
            if(!set.contains(te) && !set.contains(te2)){
                set.add(new ArrayList(currentSubset));
                return;
            }
            return;
        }

        currentSubset.add(A[currentIndex]);
        subsetUtil(A,currentIndex+1,currentSubset,set);

        currentSubset.remove(currentSubset.size()-1);
        subsetUtil(A,currentIndex+1,currentSubset,set);
	}
}