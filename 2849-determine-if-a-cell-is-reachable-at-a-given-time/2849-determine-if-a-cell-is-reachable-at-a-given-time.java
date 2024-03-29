class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if(sx==fx && sy==fy){
            if(t==1) return false;
            return true;
        }
        
        int k=Math.max(Math.abs(sx-fx),Math.abs(sy-fy));
        
        if(k<=t){
            return true;
        }
        
        return false;
    }
    
    
}