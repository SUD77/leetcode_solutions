///Dijkstra Algorithm 


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        
        /* Create adjacency list of type
        {{ {v node, time (from u to v)}, { v2 node, time (from u to v)} } , { <source - u node>} }
            <source - u node>                                                                   
        
        */
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][2],times[i][1]));
        }
        
        
        // From here, basic Dijkstra algo implementation
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
            
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.dist-y.dist);
        
        dist[k]=0;
        
        pq.add(new Pair(0,k));
        
        while(!pq.isEmpty()){
            
            Pair pair=pq.poll();
            
            int currDist=pair.dist;
            int currNode=pair.node;
            //System.out.println("currNode : " + currNode + " currDist: " + currDist);
            
            for(Pair it:adj.get(currNode)){
                
                int adjNode=it.node;
                int adjDist=it.dist;
                
                if(adjDist + currDist < dist[adjNode]){
                    dist[adjNode] = adjDist + currDist;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        
        //System.out.println(Arrays.toString(dist));
        
        
        // We want the max time in dist array. 
        int minTime=0;
        
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            
            minTime=Math.max(minTime,dist[i]);
        }
        
        return minTime;
    }
}

class Pair{
    int node;
    int dist;
    public Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}