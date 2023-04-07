class Solution {
    public int numDistinct(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);    
        }
        
        return solUtil(s,t,s.length(),t.length(),dp);
    }
    
    public int solUtil(String s, String t,int i,int j,int[][] dp){
        
        if(j==0) return 1;
        if(i==0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
            
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=solUtil(s,t,i-1,j-1,dp) + solUtil(s,t,i-1,j,dp);
        }else{
            return dp[i][j]=solUtil(s,t,i-1,j,dp);
        }
    }
}