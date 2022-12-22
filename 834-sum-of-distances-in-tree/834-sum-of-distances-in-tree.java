class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        ArrayList<Integer>[] adjList=makeAdjList(n,edges);
        
        int[] count=new int[n];
        
        Arrays.fill(count,1);
        
        int[] answer=new int[n];
        
        postOrder(0,-1,adjList,count,answer);
        
        preOrder(0,-1,adjList,count,answer,n);
        
        return answer;
        
        
    }
    
    public ArrayList<Integer>[] makeAdjList(int n,int[][] edges){
        
        ArrayList<Integer>[] adjList=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            
            adjList[edges[i][0]].add(edges[i][1]);
            
            if(edges[i][0]==edges[i][1]) continue;
            
            adjList[edges[i][1]].add(edges[i][0]);
            
        }
        
        return adjList;
    }
    
    public void postOrder(int node, int parent, ArrayList<Integer>[] adjList, int[] count, int[] answer){
        
        for(int child : adjList[node]){
            
            if(child !=parent){
                
                postOrder(child,node,adjList,count,answer);
                count[node]+=count[child];
                answer[node]+=answer[child] + count[child];
            }
        }
    }
    
    public void preOrder(int node, int parent, ArrayList<Integer>[] adjList, int[] count, int[] answer, int n){
        
        for(int child : adjList[node]){
            
            if(child!=parent){
                answer[child]=answer[node] + (n-count[child])-count[child];
                preOrder(child,node,adjList,count,answer,n);
            }
        }
    }
}