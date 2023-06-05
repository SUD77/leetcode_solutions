class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        /*
        formula used : 
        (y-y2) / (y2-y1) = (x-x2)/(x2-x1)
        
        In  multiplication form (To avoid / 0) : 
        
        (y - y2) (x2-x1)  = (x - x2) (y2 - y1)
        
        */
        
        int x1 = coordinates[0][0] , y1 = coordinates[0][1];
        int x2 = coordinates[1][0] , y2 = coordinates[1][1];
        
        int dx = x2 - x1, dy = y2 - y1;
        
        for(int[] point: coordinates){
            
            int x = point[0], y = point[1];
            
            if(dx * (y - y2) != dy * (x - x2)) return false;
        }
        
        
        return true;
    }
}