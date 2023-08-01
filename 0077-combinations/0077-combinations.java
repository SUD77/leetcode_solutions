//https://leetcode.com/problems/combinations/discuss/3849826/Beats-83-in-time-and-84-in-Memory-oror-Easy-Java-Solution

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        combination(result,new ArrayList<>(),1,n,k);
        return result;
    }

    public static void combination(List<List<Integer>> result,List<Integer> tmp, int sn, int n, int k){
        if(k==0){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=sn;i<=n;i++){
            tmp.add(i);
            combination(result,tmp,i+1,n,k-1);
            tmp.remove(tmp.size()-1);
        }
    }
}