class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    
        ArrayList<Integer>[] adjList=edgesToAdjList(n,edges);
        
        boolean[] vis=new boolean[n];
        
        // for(ArrayList<Integer> y:adjList){
        //     System.out.println(y);
        // }
        
        return dfs(0,adjList,vis,hasApple);
    }
    
    
    int dfs(int index, ArrayList<Integer>[] adjList,boolean[] vis,List<Boolean> hasApple){
        
        vis[index]=true;

        int total=0;
        
        for(Integer x:adjList[index]){
            
            if(!vis[x])
            total+=dfs(x,adjList,vis,hasApple);
                    
        }
        
        if(index!=0 && (hasApple.get(index) || total > 0 ))
            total+=2;
        
        return total;
    }
    
    
    ArrayList<Integer>[] edgesToAdjList(int n,int[][] edges){
        
        ArrayList<Integer>[] adjList=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<edges.length;i++){
            
            adjList[edges[i][0]].add(edges[i][1]);
            
            if(edges[i][0]==edges[i][1]){
                continue;
            }
            
            adjList[edges[i][1]].add(edges[i][0]);
                
        }
        
        return adjList;
        
    }
    
}