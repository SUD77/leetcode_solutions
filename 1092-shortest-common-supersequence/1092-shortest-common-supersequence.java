class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        
        int len1=str1.length();
        int len2=str2.length();
        
        int[][] dp=new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            dp[i][0]=0;
        }
        
        for(int i=0;i<=len2;i++){
            dp[0][i]=0;
        }
        
        
        for(int idx1=1;idx1<=len1;idx1++){
            
            for(int idx2=1;idx2<=len2;idx2++){
                
                if(str1.charAt(idx1-1)==str2.charAt(idx2-1)){
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                }else{
                    dp[idx1][idx2]=0+Math.max(dp[idx1-1][idx2],dp[idx1][idx2-1]);
                }
            }
        }
        
        
        
        /*Till above tabulation of LCS was used. From here onwards logic for
        getting Supersequence is implemented*/
        
        int len=dp[len1][len2];
        
        int i=len1;
        int j=len2;
        
        int index=len-1;
        
        String ans="";
        
        while(i>0 && j>0){
            
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                
                ans+=str1.charAt(i-1);
                index--;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                
                ans+= str1.charAt(i-1);
                i--;
            }else {
                
                ans+= str2.charAt(j-1);
                j--;
            }
        }
        
        
        while(i>0){
            ans+=str1.charAt(i-1);
            i--;
        }
        
        
         while(j>0){
            ans+=str2.charAt(j-1);
            j--;
        }
        
        
        String result=new StringBuilder(ans).reverse().toString();
        
        
        return result;
    }
}