class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        int[] color=new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!dfs(graph,i,color)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph,int node,int[] color){
        
        for(int neighbour:graph[node]){
            if(color[neighbour]==-1){
                color[neighbour]=1-color[node];
                if(!dfs(graph,neighbour,color)) return false;
            }else if(color[neighbour]==color[node]) return false;
        }
        
        return true;
    }
}