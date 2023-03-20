class Solution {
    public int minPathSum(int[][] grid) {
     
        int m=grid.length;
        int n=grid[0].length;
        
       int[] curr=new int[n];
        int[] prev=new int[n];
        
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            
                if(i==0 && j==0) {
                    curr[0]=grid[0][0];
                }else{
                    
                    int currV=grid[i][j];
                    int left=Integer.MAX_VALUE;
                    int up=Integer.MAX_VALUE;
                    
                    if(j>=1) left=curr[j-1];
                    if(i>=1) up=prev[j];
        
                    curr[j]=currV+Math.min(left,up);
                }
                
                prev=curr;
            }
        }
        
        return prev[n-1];
    }
    
}