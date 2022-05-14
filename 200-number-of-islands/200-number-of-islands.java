class Solution {
    public int numIslands(char[][] grid) {
        
        //Visited array to track all visited elements
        boolean[][]  visited=new boolean[grid.length][grid[0].length]; 
        int noOfIsland=0;
        
        int row=grid.length;
        int column=grid[0].length;
        
        
        /*Loop will go through all the elements of matrix, but will call solUtil function,
        only if element is not visited and is equal to 1. */
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                
                if(visited[i][j]!=true && grid[i][j]=='1'){
                    solUtil(grid,i,j,visited);
                    noOfIsland++;
                }
            }
        }
        
        return noOfIsland;
    }
    
    
    // This implements DFS on grid algorithm
    public void solUtil(char[][] grid,int x,int y,boolean[][] visited){
        
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
            return;
        }
        
        if(grid[x][y]=='0') {
            visited[x][y]=true;
            return;
        }
        
        if(visited[x][y]==true) return;
        
        visited[x][y]=true;
        
        solUtil(grid,x-1,y,visited);
        solUtil(grid,x,y-1,visited);
        solUtil(grid,x,y+1,visited);
        solUtil(grid,x+1,y,visited);
        
    }
    
    
}