/* DFS

*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        
        int[] color=new int[n]; //[0,1,0,-1]
        Arrays.fill(color,-1);
        
        //i=0
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(graph,color,i)) return  false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph,int[] color,int i){
        
        if(color[i]==-1) color[i]=0;
        
        //System.out.println("Value of i ==" + i + " Color arr : " + Arrays.toString(color));
        // 1,2,3
        // 0,2
        // 0,1,3
        for(int it:graph[i]){
            if(color[it]==-1){
                color[it]=1-color[i];
                if(!dfs(graph,color,it)) return false;
            }else if(color[it]==color[i]){
                return false;
            }
        }
        
        return true;
    }
}