class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int m=flights.length;
        
        List<List<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        Queue<Tuple> q=new LinkedList<>();
        
        q.add(new Tuple(0,src,0));
        
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        while(!q.isEmpty()){
            
            Tuple t=q.poll();
            
            int currStop=t.stop;
            int currNode=t.node;
            int currPrice=t.price;
            
            for(Pair it:adj.get(currNode)){
                
                int adjNode=it.node;
                int edgePrice=it.price;
                
                if(currStop + 1 <= k || (currStop + 1 == k+1 && adjNode==dst)){
                    
                    if(currPrice + edgePrice < dist[adjNode]){
                        
                        dist[adjNode]=currPrice + edgePrice;
                        q.add(new Tuple(currStop+1,adjNode,dist[adjNode]));
                    }
                }       
            }
            
        }
        
        
        return dist[dst]!=Integer.MAX_VALUE ? dist[dst] : -1;
        
        
    }
    
    class Pair{
    
        int node;
        int price;
        
        public Pair(int node,int price){
            this.node=node;
            this.price=price;
        }
    }
    
    
    class Tuple{
        
        int stop;
        int node;
        int price;
        
        public Tuple(int stop,int node,int price){
            this.stop=stop;
            this.node=node;
            this.price=price;
        }
    }
    
}