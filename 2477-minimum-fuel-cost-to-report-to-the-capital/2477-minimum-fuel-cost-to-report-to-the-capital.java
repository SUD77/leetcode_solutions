class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        if(roads.length==0) return 0;
        
        int n=roads.length;
        boolean[] vis=new boolean[n+1];
        long[] ans={0};
        
        ArrayList<Integer>[] adjList=edgeToList(roads,n);
        
        dfs(adjList,seats,vis,ans,0);
        
        return ans[0];
        
        
    }
    
    public long dfs(ArrayList<Integer>[] adjList,int seats,boolean[] vis,long[] ans,int node){
        
        vis[node]=true;
        
        long count=1;
        
        for(int i=0;i<adjList[node].size();i++){
            
            int curr=adjList[node].get(i);
            
            if(!vis[curr]) 
                count+=dfs(adjList,seats,vis,ans,curr);
        }
        
        long x=count/seats;
        
        if((count%seats) > 0) x++;
        
        if(node!=0) ans[0]+=x;
        
        return count;
    }
    
    public ArrayList<Integer>[] edgeToList(int[][] edges,int n){
        
        ArrayList<Integer>[] adjList=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            adjList[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<edges.length;i++){
            
            adjList[edges[i][0]].add(edges[i][1]);
            if(edges[i][0] != edges[i][1])
                adjList[edges[i][1]].add(edges[i][0]);
        }
        
        return adjList;
    }
}