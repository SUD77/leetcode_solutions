class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
        int len1=text1.length();
        int len2=text2.length();
        
        
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<len2;i++){       
                dp[0][i]=0; 
        }
          
        for(int i=0;i<len1;i++){
                dp[i][0]=0;
        }
        
        
        for(int i=1;i<=len1;i++){
            
            
            for(int j=1;j<=len2;j++){
                
                if(text1.charAt(i-1)==text2.charAt(j-1)) 
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        
        
        
        //from here Printing of lcs logic is implemented 
        
        int tempLen = dp[len1][len2];
        int i=len1;
        int j=len2;
        
        int index=tempLen-1;
        String str="";
        
        for(int k=1;k<=tempLen;k++){
            str+="$";
        }
        
        StringBuilder ss=new StringBuilder(text1);
        StringBuilder str2=new StringBuilder(str);
        
        while(i>0 && j>0){
            
            if(ss.charAt(i-1)== text2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1));
                index--;
                i--;
                j--;
            }else if(ss.charAt(i-1) > text2.charAt(j-1)){
                i--;
            }else j--;
        }
        
        System.out.println(str2);
        
        
        return dp[len1][len2];
    }
    
    
}