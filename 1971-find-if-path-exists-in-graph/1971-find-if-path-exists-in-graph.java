class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      
        ArrayList<Integer>[] adjList=edgesToAdjList(n,edges);
        
        // for(ArrayList<Integer> x:adjList){
        //     for(Integer y:x){
        //         System.out.println(y);
        //     }
        //     System.out.println();
        // }
        
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        
        int currentEle, tempSize;
        
        queue.offer(source);
        
        visited[source]=true;
        
        while(!queue.isEmpty()){
            
            tempSize=queue.size();
            
            currentEle = queue.poll();
            
            if(currentEle==destination) return true;
            
            for(Integer neighbour:adjList[currentEle]){
                
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
            
        }
        
        return false;
    }
    
    
   public ArrayList<Integer>[] edgesToAdjList(int n, int[][] edges) {
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
			if (edges[i][0] == edges[i][1]) {
				continue;
			}
			adjList[edges[i][1]].add(edges[i][0]);
		}
		return adjList;
    }
}