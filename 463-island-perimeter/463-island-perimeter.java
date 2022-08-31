class Solution {
    public int islandPerimeter(int[][] grid) {
        
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        int result=0;
        
        int row=grid.length;
        int column=grid[0].length;
         
        
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                
                if(!visited[i][j] && grid[i][j]==1){
                    result=solUtil(grid,i,j,visited); //dfs
                }
            }
            
        }
        
        return result;
        
    }
    
    public int solUtil(int[][] grid,int x,int y,boolean[][] visited){
        
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){ //out of boundary
            return 1;
        }
        
        if(grid[x][y]==0){
            visited[x][y]=true;
            return 1;
        }
        
        if(visited[x][y]==true) return 0;
        
        visited[x][y]=true;
        
        int a1=solUtil(grid,x-1,y,visited);
        int a2=solUtil(grid,x,y-1,visited);
        int a3=solUtil(grid,x,y+1,visited);
        int a4=solUtil(grid,x+1,y,visited);
        
        return a1+a2+a3+a4;
    }
}