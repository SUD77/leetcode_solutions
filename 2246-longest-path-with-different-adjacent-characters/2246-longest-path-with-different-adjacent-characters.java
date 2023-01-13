/*
https://www.youtube.com/watch?v=yTflID2AMm8
*/

class Solution {
    
    int dist[]=new int[100005];
    int ans=1;
    
    public int longestPath(int[] parent, String s) {
       
        int n=parent.length;
    
        ArrayList<Integer>[] adjList=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<Integer>();
        }
        
        for(int i=1;i<n;i++){
            adjList[parent[i]].add(i);
        }
        
        dfs(0,s,adjList);
        
        return ans;
    }
    
    void dfs(int src, String s, ArrayList<Integer>[] adjList){
        
        dist[src] = 1;
        
        for(int node: adjList[src]){
            
            dfs(node,s,adjList);
            
            if(s.charAt(src)!=s.charAt(node)){
                
                ans=Math.max(ans,dist[src] + dist[node]);
                dist[src]=Math.max(dist[src], dist[node]+1);
            }
        }
    }
}