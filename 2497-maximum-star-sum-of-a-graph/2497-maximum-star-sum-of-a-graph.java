class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        
        int n=vals.length;
       
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(i,vals[i]);
        }

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(mp.get(edges[i][1]));
            if (edges[i][0] == edges[i][1]) {
                continue;
            }
            adjList[edges[i][1]].add(mp.get(edges[i][0]));


        }

        long ans=Long.MIN_VALUE;

        int l=0;
        
        for(ArrayList<Integer> x:adjList){

            
            Collections.sort(x,Collections.reverseOrder());

            long temp=mp.get(l);
            long summ=mp.get(l);
            for(int itr=0;itr<k  & itr<x.size();itr++){
                summ+=x.get(itr);
                temp=Math.max(temp,summ);
            }

            ans=Math.max(ans,temp);
            
            l++;
        }
        
     

        return (int) ans;
    }
}