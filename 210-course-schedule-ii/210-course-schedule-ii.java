/*
1. Used topo sort to solve this. (Topo sort using bfs)

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int V = numCourses;
        
        //create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            /*
            Draw this on paper. Have created so that, in graph we can see
            indegree wise.
            
            */
            adj.get(b).add(a);
        }
        
        
        
        //Will store inDegree in this for every vertex
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
        
        /*Count no of vertices in topo[]. If i.e equal to total V, no cycle.
        i.e all courses are done. 
        */
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
    
        //System.out.println("count " + count);
        if(count!=V) return new int[]{};
            
        return topo;
        
    }
}