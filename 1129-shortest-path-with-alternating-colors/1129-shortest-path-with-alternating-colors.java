/*
https://leetcode.com/problems/shortest-path-with-alternating-colors/discuss/339997/Intuitive-Java-Solution-With-Explanation
*/


class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        
        List<Integer>[] redAdjList=new ArrayList[n];
        List<Integer>[] blueAdjList=new ArrayList[n];
        
        Queue<int[]> q=new LinkedList<>();
        
        int[] res=new int[n];
        Arrays.fill(res,-1);
        
        //creating adjacenty list of redEdges
        for(int[] node:redEdges){
            if(redAdjList[node[0]]==null)
                redAdjList[node[0]] = new ArrayList<>();
            redAdjList[node[0]].add(node[1]);
        }
        
        //creating adjacenty list of blueEdges
        for(int[] node:blueEdges){
            if(blueAdjList[node[0]]==null)
                blueAdjList[node[0]] = new ArrayList<>();
            blueAdjList[node[0]].add(node[1]);
        }
        
        
        q.add(new int[]{0,0});
        int moves=0;
        
        Set<String> seen=new HashSet<>();
        
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                
                int[] curr=q.remove();
                
                String key=curr[0]+" "+curr[1];
                
                if(seen.contains(key)) continue;
                seen.add(key);
                
                if(res[curr[0]]==-1)
                    res[curr[0]]=moves;
                
                if(curr[1]==2 || curr[1]==0)
                    if( redAdjList[curr[0]]!=null)
                        for(int child:  redAdjList[curr[0]])
                            q.add(new int[]{child,1});
                
                if(curr[1]==1 || curr[1]==0)
                    if(blueAdjList[curr[0]]!=null)
                        for(int child:blueAdjList[curr[0]])
                            q.add(new int[]{child,2});
            }
            ++moves;
        }
        
        return res;
        
    }
}