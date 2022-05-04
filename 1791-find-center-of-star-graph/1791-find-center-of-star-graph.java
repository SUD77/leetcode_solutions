class Solution {
    public int findCenter(int[][] edges) {
        
        int ans=0;
        int n=edges.length;
        System.out.println(n);
        Map<Integer,Integer> temp= new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<edges[i].length;j++){
                temp.put(edges[i][j],temp.getOrDefault(edges[i][j],0)+1);
            }
        }

        System.out.println(temp);

        for(Map.Entry x:temp.entrySet()){
            int key= (int) x.getKey();
            int value= (int) x.getValue();

            if(value==n) {
                ans=key;
                break;
            }   
        }
        
        return ans;
    }
}