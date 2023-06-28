class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        int[] color=new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(graph,color,i)) return false;
            }
        }
        
        return true;
    }
    
    public boolean bfs(int[][] graph,int[] color, int i){
        
        Queue<Integer> q=new LinkedList<>();
        
        color[i]=0;
        q.add(i);
        
        
        while(!q.isEmpty()){
            
            int tempV=q.poll();
            
            for(int it:graph[tempV]){
                if(color[it]==-1){
                    color[it]=1-color[tempV];
                    q.add(it);
                }else if(color[it]==color[tempV]){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}