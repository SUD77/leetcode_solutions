class Solution {
    public int countNegatives(int[][] grid) {
        
        int count=0;
        
        for(int[] x:grid){
            for(int y:x){
                if(y<0) count++;
            }
        }
        
        return count;
    }
}