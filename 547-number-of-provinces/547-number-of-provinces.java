class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n=isConnected.length;
        
        ArrayList<Integer>[] adjList=edgesToList(n,isConnected);
        
        // for(ArrayList<Integer> x:adjList){
        //     System.out.println(x);
        // }
        
        boolean[] vis=new boolean[n+1];
        int provinces=0;
        
        for(int i=1;i<n+1;i++){
            
            if(!vis[i]){
                dfs(i,adjList,vis);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    
    public void dfs(int node,ArrayList<Integer>[] adjList,boolean[] vis){
        
        vis[node]=true;
        
        for(int x:adjList[node]){
            if(!vis[x]) dfs(x,adjList,vis);
        }
        
        
    }
    
    ArrayList<Integer>[] edgesToList(int n,int[][] edges){
    
        ArrayList<Integer>[] adjList=new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++){
            adjList[i]=new ArrayList<>();
        }
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                
                if(i!=j && edges[i][j]==1)
                    adjList[i+1].add(j+1);
            }
            
        }
        
        
        return adjList;
    }
}