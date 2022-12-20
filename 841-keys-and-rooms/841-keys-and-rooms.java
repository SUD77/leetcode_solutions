class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n=rooms.size();


        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        
        int currentEle;
        int tempSize;
        
        queue.offer(0);

        visited[0]=true;
        
        while(!queue.isEmpty()){
            
            tempSize=queue.size();
            
            currentEle = queue.poll();
            
            for(Integer neighbour:rooms.get(currentEle)){
                
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
            
        }
        
        for(boolean x:visited){
            if(x!=true) return false;
        }
        
        return true;
    }
    
}