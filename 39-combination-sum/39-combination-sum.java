class Solution {
    public List<List<Integer>> combinationSum(int[] A, int val) {
        
        List<List<Integer>> result=new ArrayList<>();
        combiUtil(A,val,0,new ArrayList(),result);

        return result;
    }
    
    public static void combiUtil(int[] A,int target, int currentIndex, List<Integer> currentSubset, List<List<Integer>> result){

        if(currentIndex==A.length){
            return;
        }
        int sum=0;

        for(Integer x:currentSubset){
            sum+=x;
        }


        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList(currentSubset));
            return;
        }
       

        currentSubset.add(A[currentIndex]);
		//to add the same element in currentSubset till either sum is greater or equal
        combiUtil(A,target,currentIndex,currentSubset,result);

        currentSubset.remove(currentSubset.size()-1);
        combiUtil(A,target,currentIndex+1,currentSubset,result);
    }
}