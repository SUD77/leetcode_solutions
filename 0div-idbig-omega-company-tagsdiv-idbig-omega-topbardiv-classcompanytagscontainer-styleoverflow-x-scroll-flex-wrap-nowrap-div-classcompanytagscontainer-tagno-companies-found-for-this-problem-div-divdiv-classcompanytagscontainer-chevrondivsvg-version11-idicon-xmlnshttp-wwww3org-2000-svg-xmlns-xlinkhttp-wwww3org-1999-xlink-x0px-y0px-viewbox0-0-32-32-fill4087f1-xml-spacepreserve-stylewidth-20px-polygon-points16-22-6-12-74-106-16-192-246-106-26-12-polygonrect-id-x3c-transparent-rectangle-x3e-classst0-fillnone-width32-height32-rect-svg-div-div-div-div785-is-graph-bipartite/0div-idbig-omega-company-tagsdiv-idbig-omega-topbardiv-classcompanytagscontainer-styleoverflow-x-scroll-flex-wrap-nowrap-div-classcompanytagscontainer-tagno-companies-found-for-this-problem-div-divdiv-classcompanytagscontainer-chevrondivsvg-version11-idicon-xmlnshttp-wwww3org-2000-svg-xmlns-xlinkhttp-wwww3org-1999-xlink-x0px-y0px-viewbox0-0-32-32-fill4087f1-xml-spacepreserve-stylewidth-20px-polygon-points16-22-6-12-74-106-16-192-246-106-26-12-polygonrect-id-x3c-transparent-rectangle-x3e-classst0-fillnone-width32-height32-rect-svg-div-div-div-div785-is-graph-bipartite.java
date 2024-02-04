//Tc : O(N + E)
//Sc : O(N + E)

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        int[] color=new int[n];
        
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            
            if(color[i]==-1){
              if(!dfs(i,graph,color)) return false; 
            }
            
        }
        
        return true;
    }
    
    public boolean dfs(int i,int[][] graph,int[] color){
        
        
        if(color[i]==-1) color[i]=0;
        
        for(int x:graph[i]){
            
            if(color[x]==-1){
                color[x]=1-color[i];
                if(!dfs(x,graph,color)) return false;
            }else{
                if(color[x]==color[i]) return false;
            }            
            
        }
        
        return true;
    }
}