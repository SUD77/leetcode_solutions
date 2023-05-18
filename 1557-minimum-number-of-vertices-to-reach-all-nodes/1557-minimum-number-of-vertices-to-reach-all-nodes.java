class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> ans=new ArrayList<>();
        
        boolean[] inDegree=new boolean[n];
        
        for(List<Integer> edge:edges){
            inDegree[edge.get(1)]=true;
        }
        
        for(int i=0;i<n;i++){
            if(!inDegree[i]){
                ans.add(i);
            }
        }
        
        return ans;
    }
}