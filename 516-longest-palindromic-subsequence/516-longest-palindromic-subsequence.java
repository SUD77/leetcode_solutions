class Solution {
    public int longestPalindromeSubseq(String s) {
        
        //reversing the String 
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        
        int len1=s.length();
        int len2=s2.length();
        
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);    
        }
        
        return solUtil(s,s2,len1-1,len2-1,dp);
    }
    
    public int solUtil(String s1,String s2,int i,int j,int[][] dp){
        
        if(i<0 || j<0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+solUtil(s1,s2,i-1,j-1,dp);
        }
        
        return dp[i][j]=Math.max(solUtil(s1,s2,i-1,j,dp),solUtil(s1,s2,i,j-1,dp));
    }
}