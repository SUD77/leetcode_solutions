class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int V=numCourses;
        
        
        //create adj list
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            
            adj.get(a).add(b); 
        }
        
        // add your code here
        int inDegree[] = new int[V];
        
        for(int i=0;i<V;i++){
            
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        
        
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int topo[] = new int[V];
        int i=0;
        int count=0;
        
        while(!q.isEmpty()){
            
            int node=q.poll();
            count++;
            topo[i++]=node;
            
            for(int it:adj.get(node)){
                
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        if(count==V) return true;
        
        return false;
        
    }
    
    
}