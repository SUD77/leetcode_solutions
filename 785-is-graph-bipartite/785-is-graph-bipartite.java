class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        int[] color=new int[n];
        
        Arrays.fill(color,-1);
        
        
        for(int i=0;i<n;i++){
            
            if(color[i]==-1){
                
                if(!bfs(graph,i,color)) return false;
            }
        }
        
        return true;
    }
    
    public boolean bfs(int[][] graph,int node,int[] color){
        
        
        Queue<Integer> q=new LinkedList<>();
        
        q.add(node);
        color[node]=1;
        
        while(!q.isEmpty()){
            
            int tempNode=q.poll();
            
            for(int x:graph[tempNode]){
                
                if(color[x]==-1){
                    color[x]=1-color[tempNode];
                    q.add(x);
                }else if(color[x]==color[tempNode]){
                    return false;
                }
            }
            
        }
        
        return true;
    } 
}