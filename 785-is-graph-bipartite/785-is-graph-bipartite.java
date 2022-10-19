//DFS

class Solution {
    public boolean isBipartite(int[][] graph) {
       
        int n=graph.length;
        
        int[] color=new int[n];
        
        //-1 is no color
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            
            if(color[i]==-1){
                
                if(!dfs(graph,i,color)) return false;
            }
        }
        
        return true;
           
    }
    
    public boolean dfs(int[][] graph,int index,int[] color){
        
        
        if(color[index]==-1) color[index]=1;
        
        for(int x:graph[index]){
            
            if(color[x]==-1){
                
                color[x]=1-color[index];
                
                if(!dfs(graph,x,color)) return false;                    
            
            }else if(color[x]==color[index]){
                return false;
            }
        }
        
        return true;
    }
}

