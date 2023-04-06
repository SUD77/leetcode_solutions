class Solution {
    public int closedIsland(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] vis=new boolean[n][m];
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]==0 && !vis[i][j]){
                    if(solUtil(grid,i,j,vis)) ans++;
                    
                }
            }
        }
        
        return ans;
    }
    
    public boolean solUtil(int[][] grid,int i,int j,boolean[][] vis){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        
        if(vis[i][j]) return true;
        
        if(grid[i][j]==0) vis[i][j]=true;
        if(grid[i][j]==1) return true;
        
        boolean up=solUtil(grid,i-1,j,vis);
        boolean down=solUtil(grid,i+1,j,vis);
        boolean left=solUtil(grid,i,j-1,vis);
        boolean right=solUtil(grid,i,j+1,vis);
        
        return (up && down && right && left);
    }
}