class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n=numCourses;
        
        
        //create adj list
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            
            adj.get(a).add(b);
        }
        
        
        boolean vis[]=new boolean[n];
        boolean pathVis[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            
            if(!vis[i]){
                if(dfs(i,adj,vis,pathVis)==false) // means cycle is found
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int i,List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        
        vis[i]=true;
        pathVis[i]=true;
        
        for(int it:adj.get(i)){
            
            if(!vis[it]){
                
                if(dfs(it,adj,vis,pathVis)==false){
                    return false;
                }
            }
            /*
            path vis ka matlab ki current path jo chal rahi hai, usme ye node "it" aya ya nahi
            */
            else if(pathVis[it]){
                return false; //cycle found, deadlock , we cant finish all courses ,so false
            }
        }
        pathVis[i]=false;
        return true;
    }
}