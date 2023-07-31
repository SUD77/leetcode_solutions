//Printing LCS ..................
//Tabu
//TC =  O(n1 x n2)
//SC =  O(n x m )dp[][]

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        
        int dp[][] = new int[n1+1][n2+1];
        //Initialisation
        for(int i=0; i<=n1; i++) dp[i][0] = 0;
        for(int j=0; j<=n2; j++) dp[0][j] = 0;  
        
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))  
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                else{
                    dp[i][j] = 0 + Math.max(dp[i][j-1], dp[i-1][j]) ;
                }
            }
        }
        //Printing LCS
        int i=n1;
        int j = n2;
        String str = "";
        
        while(i>=1 && j>=1){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                str += text1.charAt(i-1); 
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;                
            }
            else{
                j--;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        String lcs = sb.reverse().toString();
        System.out.println("LCS String = " + lcs);
        return dp[n1][n2]; 
    }
}