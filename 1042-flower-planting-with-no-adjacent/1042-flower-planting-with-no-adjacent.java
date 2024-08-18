class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        List<List<Integer>> adjList=new ArrayList<>();
        
        int[] ans=new int[n+1];
        
        for(int i=0;i<n+1;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] x:paths){
            adjList.get(x[0]).add(x[1]);
            adjList.get(x[1]).add(x[0]);
        }
        
        // for(List<Integer> x:adjList){
        //     System.out.println(x);
        // }
        
        int plants=4;
        
        solve(1,adjList,n,plants,ans);
        
        
        int[] finalAns=new int[n];
        
        int j=0;
        for(int i=1;i<ans.length;i++){
            finalAns[j++]=ans[i];
        }
        
        return finalAns;
    }
    
    
    public boolean solve(int node,List<List<Integer>> adjList,int n,int plants,int[] ans){
        
        if(node>n) return true;
        
        for(int currPlant=1;currPlant<=plants;currPlant++){
            
            if(isPossible(node,currPlant,adjList,ans,n)){
                ans[node]=currPlant;
                if(solve(node+1,adjList,n,plants,ans)) return true;
                ans[node]=0;
            }
        }
        
        return false;
    }
    
    
    public boolean isPossible(int node,int nodePlant, List<List<Integer>> adjList,int[] ans,int n){
        
       for(Integer x:adjList.get(node)){
           if(ans[x]==nodePlant) return false;
       }
        
       return true; 
    }
}