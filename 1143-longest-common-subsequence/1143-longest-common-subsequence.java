class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1=text1.length();
        int len2=text2.length();
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(text1,text2,0,0,dp);
    }

    public int solUtil(String text1, String text2,int i,int j,int[][] dp){
        
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        
        if(dp[i][j]!=-1) return dp[i][j]; 
        
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+solUtil(text1,text2,i+1,j+1,dp);
        }
        
        return dp[i][j]= Math.max(solUtil(text1,text2,i+1,j,dp),solUtil(text1,text2,i,j+1,dp)); 
    }
}