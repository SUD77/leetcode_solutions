class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int maxReach=startFuel;
        PriorityQueue<Integer> maxFuel=new PriorityQueue<>(Collections.reverseOrder()); 
        
        int count=0;
        int index=0;
        
        while(maxReach<target){
            
            
            while(index<stations.length && stations[index][0]<=maxReach){
                
                
                maxFuel.add(stations[index][1]);
                index++;
            }
            
            
            if(maxFuel.isEmpty()) return -1;
            
            maxReach+=maxFuel.poll();
            
            count++;
            
        }
        
        return count;
    }
}