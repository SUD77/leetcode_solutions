class Solution {
    public int minDistance(String word1, String word2) {
       
        int len1=word1.length();
        int len2=word2.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        
        
        return solUtil(word1,word2,len1,len2,dp);
    }
    
    public int solUtil(String word1, String word2,int i,int j,int[][] dp){
        
        if(i==0) return j;
        if(j==0) return i;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1)){
            return solUtil(word1,word2,i-1,j-1,dp);
        }
        
        int insert=1+solUtil(word1,word2,i,j-1,dp);
        int delete=1+solUtil(word1,word2,i-1,j,dp);
        int replace=1+solUtil(word1,word2,i-1,j-1,dp);
        
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}