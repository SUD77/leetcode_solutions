//TC : O(N + E)
// SC : O(N) + O(N) + O(N) + O(N + E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        boolean[] vis=new boolean[numCourses];
        boolean[] pathVis=new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            
            if(!vis[i]){
                if(dfsCycle(i,vis,pathVis,adj)) return false;
            }
        }
        
        return true;
        
    }
    
    public boolean dfsCycle(int i,boolean[] vis,boolean[] pathVis, List<List<Integer>> adj){
        
        vis[i]=true;
        pathVis[i]=true;
        
        for(int neighbour:adj.get(i)){
            
            if(!vis[neighbour]){
                if(dfsCycle(neighbour,vis,pathVis,adj)) return true;
            }else{
                if(pathVis[neighbour]) return true;
            }
        }
        
        
        pathVis[i]=false;
        return false;
    }
    
    
}