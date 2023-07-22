class Solution {
    
    private int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        
        double[][][] dp=new double[n][n][k+1];


        return solUtil(n,k,row,column,dp);
    }
    
    public double solUtil(int n,int k,int row,int column,double[][][] dp){
        if(row>=n || column >=n || row<0 || column<0) return 0;
        if(k==0) return 1;

        if(dp[row][column][k]!=0) return dp[row][column][k];

        double score=0;
        int count=0;

        for(int i = 0;i < dir.length;i++){
            score+=0.125 * solUtil(n,k-1,row+ dir[i][0],column+dir[i][1],dp);
        }

        dp[row][column][k]=score;
        return score;
        
    }
}