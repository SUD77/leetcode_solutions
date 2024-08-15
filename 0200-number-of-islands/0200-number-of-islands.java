class Solution {
    public int numIslands(char[][] grid) {
        
        
        int count=0;
        
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][] vis=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j]=='1' && !vis[i][j]){
                    solUtil(i,j,grid,vis);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    public void solUtil(int i,int j,char[][] grid,boolean[][] vis){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        
        if(grid[i][j]=='0') return;
        
        if(vis[i][j]) return;
        
        vis[i][j]=true;
        
        solUtil(i+1,j,grid,vis);
        solUtil(i,j+1,grid,vis);
        solUtil(i-1,j,grid,vis);
        solUtil(i,j-1,grid,vis);
    }
}
