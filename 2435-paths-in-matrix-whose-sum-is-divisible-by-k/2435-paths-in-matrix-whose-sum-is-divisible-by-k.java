class Solution {
    
    int mod = 1_000_000_007;
        
    public int numberOfPaths(int[][] grid, int k) {
       
        int m = grid.length;
         int n = grid[0].length;


         int dp[][][] = new int[m][n][50];

         for(int[][] x : dp){
             for(int[] y : x){
                 Arrays.fill(y , -1);
             }
         }
        
        // solUtil(grid,k,0,0,0,dp);
        
         // for(int[][] x : dp){
         //     for(int[] y : x){
         //         System.out.println(Arrays.toString(y));
         //     }
         // }
        return solUtil(grid,k,0,0,0,dp);
    }
    
    public int solUtil(int[][] grid,int k,int i,int j,int sum,int[][][] dp){

         if(i >= grid.length || j>= grid[0].length) return 0;

         
         if(i == grid.length-1 && j == grid[0].length-1) {
             sum+=grid[i][j];
             if(sum % k == 0) return 1;
             else return 0;
         }
        
         if(dp[i][j][sum%k]!=-1) return dp[i][j][sum%k];

         int right  = solUtil(grid,k, i, j+1, sum + grid[i][j],dp);
         int down  = solUtil(grid,k, i+1, j, sum + grid[i][j],dp);

         return dp[i][j][sum%k]=(down + right)%mod;

     }
}