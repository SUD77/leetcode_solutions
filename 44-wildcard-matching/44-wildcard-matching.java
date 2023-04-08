class Solution {
    public boolean isMatch(String s, String p) {
        
        int len1=s.length();
        int len2=p.length();
        
        int[][] dp=new int[len1+1][len2+1];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(s,p,len1,len2,dp)==1;
        
    }
    
    public int solUtil(String s,String p,int i,int j,int[][] dp){
        
        if(i==0 && j==0) return 1;
        
        //It means there are some comparisons still left as s in not empty
        if(i>=1 && j==0) return 0;
        
        
        /*
        This means, s is exhausted and p has still some characters left.
        So, when can p match with s that is a empty string now.
        Only when p has all *.
        */
        if(i==0 && j>=1){
            
            for(int temp=0;temp<j;temp++){
                
                if(p.charAt(temp)!='*') return 0;
            }
            return 1;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
            return dp[i][j]=solUtil(s,p,i-1,j-1,dp);
        }
        
        if(p.charAt(j-1)=='*'){
            
            // First case : If in p, we dont consider '*'
            // Second case : If we match all characters of s, to * in p at ith position
            int skipStar=solUtil(s,p,i,j-1,dp);
            int notSkipStar=solUtil(s,p,i-1,j,dp);
            
            if(skipStar==0 && notSkipStar==0){
                return dp[i][j]=0;
            }else{
                return dp[i][j]=1;
            }
            
        }
        
        return 0;
    }
}