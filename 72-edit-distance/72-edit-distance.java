class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1=word1.length();
        int len2=word2.length();
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(word1,word2,len1-1,len2-1,dp);
    }
    
    public int solUtil(String s1,String s2,int index1,int index2,int[][] dp){
        
        //s1 is exhausted
        if(index1<0) return index2+1;  
        
        //s2 is exhausted
        if(index2<0) return index1+1;
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2)) 
            return dp[index1][index2]=solUtil(s1,s2,index1-1,index2-1,dp);
        
        
        //if not equal then do insert,replace,delete
        
        int insert=1+solUtil(s1,s2,index1,index2-1,dp);
        int delete=1+solUtil(s1,s2,index1-1,index2,dp);
        int replace=1+solUtil(s1,s2,index1-1,index2-1,dp);
        
        return dp[index1][index2]=Math.min(insert, Math.min(delete,replace));
        
    }
}