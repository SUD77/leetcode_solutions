class Solution {
    public int longestPalindromeSubseq(String s) {
      
        StringBuilder sb=new StringBuilder(s);
        
        String text2=sb.reverse().toString();
        
        int len1=s.length();
        int len2=text2.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(0,0,s,text2,dp);
    }
    
    public int solUtil(int index1,int index2,String text1,String text2,int[][] dp){
        
        if(index1>=text1.length() || index2>=text2.length()) return 0;
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        int pick=0;
        if(text1.charAt(index1)==text2.charAt(index2)){
            pick=1+solUtil(index1+1,index2+1,text1,text2,dp);
        }
        
        int notPick=Math.max(solUtil(index1,index2+1,text1,text2,dp),solUtil(index1+1,index2,text1,text2,dp));
        
        return dp[index1][index2]=Math.max(pick,notPick);
    }
}