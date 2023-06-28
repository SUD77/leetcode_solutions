//Dijkstra Algorithm

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        double[] distance = new double[n];
        Arrays.fill(distance , 0);
        
        /*We want to create adj list like below :  
        Adj list of example1 = { {{1,0.5 },{2, 0.2}} ,  {{0,0.5},{2,0.5}}  , {{0,0.2},{1,0.5}} }
        Here, adj list of any node, say 0 -> list of pairs. Each pair depicts two values : adj node, along with its success probability between parent node (say 0) and adj node.  
        */
        ArrayList<ArrayList<ArrayList<Pair>>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        int i=0;
        for(int[] ele : edges){
            int u = ele[0];
            int v = ele[1];
            
            // Creating the first innermost ArrayList
            ArrayList<Pair> innermostList1 = new ArrayList<>();
            innermostList1.add(new Pair(succProb[i] , v));

            ArrayList<Pair> innermostList2 = new ArrayList<>();
            innermostList2.add(new Pair(succProb[i] , u));
            
            adj.get(u).add(innermostList1);
            adj.get(v).add(innermostList2);

            i++;
        }
        

        //basic dijkstra algorithm from here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Double.compare(y.dist, x.dist));
        pq.add(new Pair(1,start));
        
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int curNode = pair.node;
            double curDist = pair.dist;
            
            for(ArrayList<Pair> it : adj.get(curNode)){
                int adjNode = it.get(0).node;
                double adjDist = it.get(0).dist;
                
                if(curDist * adjDist > distance[adjNode] ){                    
                    distance[adjNode] = curDist * adjDist;                                        
                    pq.add(new Pair( distance[adjNode], adjNode));
                }                
            }
        }        
        return distance[end];
    }
}
class Pair{
    int node;
    double dist;
    
    public Pair(double d , int n){
        dist = d;
        node = n;
    }
}