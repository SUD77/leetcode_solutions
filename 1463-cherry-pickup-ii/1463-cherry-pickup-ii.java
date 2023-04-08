//Recursion
// TC - O((3 ^n) * (3^n))
// SC - O(n)

class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        int[][][] dp=new int[n][m][m];
        
        for(int[][] x:dp){
            for(int[] y:x){
                Arrays.fill(y,-1);
            }
        }
        
        return solUtil(grid,0,0,m-1,dp);
    }
    
    public int solUtil(int[][] grid,int i,int j,int k,int[][][] dp){
        
        if(j<0 || j>=grid[0].length || k<0 || k>=grid[0].length ) return 0;
        
        if(i==grid.length-1) {
            
            if(j==k) return grid[i][j];
            else{
                return grid[i][j] + grid[i][k];
            }
        }
        
        if(dp[i][j][k]!=-1) return dp[i][j][k]; 
        
        
        int max=Integer.MIN_VALUE;
        
        for(int dj=-1;dj<2;dj++){
            
            for(int dk=-1;dk<2;dk++){
                
                if(j == k){
                    max=Math.max(max, grid[i][j] + solUtil(grid,i+1,j+dj,k+dk,dp));
                }else {
                    max=Math.max(max, grid[i][j] + grid[i][k] + solUtil(grid,i+1,j+dj,k+dk,dp));
                }
                 
            }
    
        }
        
        return dp[i][j][k]=max;
        
    }
}

    
    

