//Memoization
// TC - O(len1 * len2)
// SC - O(len1+ len2)

class Solution {
    public int minInsertions(String s) {
        return s.length() - lps(s);
    }
    
    public int lps(String s){
        
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        
        int len1=s.length();
        int len2=s.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(s,s2,len1,len2,dp);
    }
    
    public int solUtil(String s1,String s2,int i,int j,int[][] dp){
        
        if(i<=0 || j<=0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]=1+solUtil(s1,s2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(solUtil(s1,s2,i-1,j,dp),solUtil(s1,s2,i,j-1,dp));
        }
        
        
    }
}