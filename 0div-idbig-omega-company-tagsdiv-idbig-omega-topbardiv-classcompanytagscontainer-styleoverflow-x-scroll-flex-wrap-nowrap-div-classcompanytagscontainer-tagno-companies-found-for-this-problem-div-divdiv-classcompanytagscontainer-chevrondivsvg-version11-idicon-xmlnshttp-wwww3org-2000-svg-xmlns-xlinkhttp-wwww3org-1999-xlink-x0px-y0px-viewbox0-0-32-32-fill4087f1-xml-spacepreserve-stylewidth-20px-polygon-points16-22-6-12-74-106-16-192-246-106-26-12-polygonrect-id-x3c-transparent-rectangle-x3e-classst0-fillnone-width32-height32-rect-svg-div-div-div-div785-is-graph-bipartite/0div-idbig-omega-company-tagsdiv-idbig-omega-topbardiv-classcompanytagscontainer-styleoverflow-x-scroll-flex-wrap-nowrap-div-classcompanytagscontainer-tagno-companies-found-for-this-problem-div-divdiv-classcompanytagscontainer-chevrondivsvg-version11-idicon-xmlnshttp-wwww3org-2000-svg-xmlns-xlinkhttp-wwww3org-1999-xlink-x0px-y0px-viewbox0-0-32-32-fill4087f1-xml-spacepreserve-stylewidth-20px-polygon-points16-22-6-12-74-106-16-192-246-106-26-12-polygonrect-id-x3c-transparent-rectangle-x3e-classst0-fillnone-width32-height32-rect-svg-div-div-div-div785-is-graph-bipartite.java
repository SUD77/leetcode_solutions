//Tc : O(N + E)
//Sc : O(N + E)

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        int[] color=new int[n];
        
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            
            if(color[i]==-1){
              if(!bfs(i,graph,color)) return false; 
            }
            
        }
        
        return true;
    }
    
    public boolean bfs(int i,int[][] graph,int[] color){
        
        Queue<Integer> q=new LinkedList<>();
        
        q.add(i);
        
        while(!q.isEmpty()){
            
            int node=q.poll();
            
            if(color[node]==-1) color[node]=0;
            
            for(int it:graph[node]){
                
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }else{
                    if(color[it]==color[node]) return false;
                }
            }
        }
        
        return true;
    }
}