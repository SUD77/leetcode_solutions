/*https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/discuss/3037960/Java-oror-C%2B%2B-oror-JavaScript-oror-DFS-oror-Explained-oror-Beats-100-oror-Concise-and-Clean
*/

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
       
        
        int[] ans=new int[n];
        
        ArrayList<Integer>[] adjList=edgesToAdjList(n,edges);
        
        dfs(-1,0,adjList,labels,ans);
        
        return ans;
    }
    
    int[] dfs(int prev,int curr,ArrayList<Integer>[] adjList,String labels,int[] ans){
        
        int[] tempFreqArray=new int[26];
        
        for(int child:adjList[curr]){
            
            if(prev!=child){
                
                int[] res=dfs(curr,child,adjList,labels,ans);
                
                for(int i=0;i<res.length;i++){
                    tempFreqArray[i]+=res[i];
                }
            }
        }
        
        ans[curr]=++tempFreqArray[labels.charAt(curr)-'a'];
        
        return tempFreqArray;
        
    }
    
     ArrayList<Integer>[] edgesToAdjList(int n,int[][] edges){
        
        ArrayList<Integer>[] adjList=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<edges.length;i++){
            
            adjList[edges[i][0]].add(edges[i][1]);
            
            if(edges[i][0]==edges[i][1]){
                continue;
            }
            
            adjList[edges[i][1]].add(edges[i][0]);
                
        }
        
        return adjList;
        
    }
}