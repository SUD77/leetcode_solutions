class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        
        dfsUtil(0,-1,graph,tempList,ans);
        
        return ans;
    }
    
    public void dfsUtil(int root,int parent,int[][] graph,List<Integer> tempList, List<List<Integer>> ans){
        
        tempList.add(root);
        
        System.out.println(tempList);
        
        for(int i=0;i<graph[root].length;i++){
            
            int node=graph[root][i];
            
            if(node==graph.length-1){
                tempList.add(graph.length-1);
                ans.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size()-1);
            }
                
            
           
            if(node!=parent){
                dfsUtil(node,root,graph,tempList,ans);
                 tempList.remove(tempList.size()-1);
            }
        }
    }
}