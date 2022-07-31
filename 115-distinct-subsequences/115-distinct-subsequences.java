class Solution {
    public int numDistinct(String s, String t) {
      
        int len1=s.length();
        int len2=t.length();
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        
        return solUtil(s,t,len1-1,len2-1,dp);
        
    }
    
    public int solUtil(String s,String t,int idx1,int idx2,int[][] dp){
        
        if(idx2<0) return 1;   // String t is done
        
        if(idx1<0) return 0;  //String s is done but not t
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        
        if(s.charAt(idx1)==t.charAt(idx2)){
            return dp[idx1][idx2]=solUtil(s,t,idx1-1,idx2-1,dp) + solUtil(s,t,idx1-1,idx2,dp);
        }
        
        //if they are not same
        return dp[idx1][idx2]=solUtil(s,t,idx1-1,idx2,dp);
    }
}