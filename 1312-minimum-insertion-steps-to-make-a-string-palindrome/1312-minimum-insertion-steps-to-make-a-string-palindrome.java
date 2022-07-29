class Solution {
    public int minInsertions(String s) {
       
        //Creating reverse of s
        StringBuffer tempS=new StringBuffer(s);
        tempS.reverse();
        String s2=tempS.toString();
        //end
        
        int len1=s.length();
        int len2=s2.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return len1-solUtil(s,s2,len1-1,len2-1,dp);
    }
    
    public int solUtil(String s1,String s2,int idx1,int idx2,int[][] dp){
        
        if(idx1<0 || idx2<0) return 0;
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]=1+solUtil(s1,s2,idx1-1,idx2-1,dp);
        }
        
        return dp[idx1][idx2]=Math.max(solUtil(s1,s2,idx1-1,idx2,dp),solUtil(s1,s2,idx1,idx2-1,dp));
    }
    
}