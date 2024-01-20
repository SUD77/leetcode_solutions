class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        dis[k]=0;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(0,k));
        
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][2],times[i][1]));    
        }
        
        
        while(!pq.isEmpty()){
            
            Pair currPair=pq.poll();
            
            int currNode=currPair.node;
            int currW=currPair.weight;
            
            for(Pair it:adj.get(currNode)){
                int adjNode=it.node;
                int adjW=it.weight;
                
                if(currW + adjW < dis[adjNode]){
                    dis[adjNode]=currW+adjW;
                    pq.add(new Pair(dis[adjNode],adjNode));
                }
            }
            
        }
        
        System.out.println(Arrays.toString(dis));
        int totalTime=0;
        
        for(int i=1;i<=n;i++){
            
            if(dis[i]==Integer.MAX_VALUE) return -1;
            totalTime=Math.max(totalTime,dis[i]);
        }
        
        return totalTime;
        
    }
    
    class Pair{
        
        int weight;
        int node;
        
        public Pair(int weight,int node){
            this.weight=weight;
            this.node=node;
        }
    }
}