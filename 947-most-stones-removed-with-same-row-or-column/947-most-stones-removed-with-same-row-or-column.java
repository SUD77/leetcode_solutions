// Not my code and logic

class Solution {
    public int removeStones(int[][] stones) {
        
        int n=stones.length;
        
        if(n==0) return 0;
        
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<Integer>());
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                if(stones[j][0] == stones[i][0] || stones[j][1] == stones[i][1]){
                    graph.get(i).add(j);
                }
            }
        }
        
        int[] roots=new int[n];
        
        int num=n;
        
        for(int i=0;i<n;i++) roots[i]=i;
        
        for(int i=0;i<n;i++){
            for(int j:graph.get(i)){
                
                int root_i=find(roots,i);
                int root_j=find(roots,j);
                
                if(root_i != root_j){
                    roots[root_i]=root_j;
                    num--;
                }
            }
        }
        
        return n-num;
    }
    
    private int find(int[] roots,int i){
        
        int j=i;
        while(roots[i]!=i) i=roots[i];
        
        roots[j]=i;
        return i;
    }
}