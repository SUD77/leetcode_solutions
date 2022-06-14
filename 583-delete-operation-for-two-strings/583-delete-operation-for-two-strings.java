class Solution {
    public int minDistance(String word1, String word2) {
        
        int m=word1.length();
        int n=word2.length();
        
        int[][] dp=new int[m+1][n+1];
        
        /*as i didnt fill the array values as befroe hand, that why
        I am iterating from i and j =0 */
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                
                if(i==0 || j==0) dp[i][j]=0;
                else {
                
                    dp[i][j] = (word1.charAt(i-1)==word2.charAt(j-1)) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        int val=dp[m][n];
        
        return m-val+n-val;
        
        
    }
}