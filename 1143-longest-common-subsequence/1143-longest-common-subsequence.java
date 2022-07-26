class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
        int len1=text1.length();
        int len2=text2.length();
        
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(text1,text2,len1-1,len2-1,dp);
    }
    
    public int solUtil(String text1,String text2, int index1,int index2,int[][] dp){
        
        
        if(index1<0 || index2<0) return 0;
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        if(text1.charAt(index1)==text2.charAt(index2)) 
            return dp[index1][index2]=1+solUtil(text1,text2,index1-1,index2-1,dp);
        
        
        return dp[index1][index2]= 0+Math.max(solUtil(text1,text2,index1-1,index2,dp),solUtil(text1,text2,index1,index2-1,dp));
    }
}