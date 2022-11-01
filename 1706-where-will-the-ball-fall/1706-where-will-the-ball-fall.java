/* https://leetcode.com/problems/where-will-the-ball-fall/discuss/995242/JAVA-or-Simple-DFS-solution-or-100-Runtime */

class Solution {
    public int[] findBall(int[][] grid) {
        
        int m=grid[0].length;
        
        int[] result=new int[m];
        
        for(int j=0;j<m;j++){
            result[j]=dfs(grid,0,j);
        }
        
        return result;
    }
    
    public int dfs(int[][] grid,int i,int j){
        
        if(i==grid.length)
            return j;
        
        if(j<0 || j>=grid[0].length)
            return -1;
        
        if(grid[i][j]==1 && j+1<grid[0].length && grid[i][j+1]==1)
            return dfs(grid,i+1,j+1);
        else if(grid[i][j]==-1 && j-1>=0 && grid[i][j-1]==-1)
            return dfs(grid,i+1,j-1);
        
        return -1;
    }
}