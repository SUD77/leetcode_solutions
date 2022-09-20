//Longest Common Substring -> Tabulation Code -> from my github
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int dp[][] = new int[len1+1][len2+1];
      
        //1. Initialise
        for(int i=0; i<=len1; i++) dp[i][0] = 0;
        for(int j=0; j<=len2; j++) dp[0][j] = 0;
        
        int ans =0;
        //2. For loop
        for(int i=1; i<=len1 ; i++){
            for(int j=1; j<=len2; j++){
                
                //3. Copy recurrence
               //Match
                if(nums1[i-1] == nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];  //-----------check if prev char was matching.
                //Not Match
                else dp[i][j] = 0; //--------------- for every non-match, we aassign 0.
                ans = Math.max(ans, dp[i][j]);
            }
        }       
        return ans;        
	}
}