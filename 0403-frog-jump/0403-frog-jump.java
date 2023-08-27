// https://leetcode.com/problems/frog-jump/discuss/3964889/Simple-Java-Solution-oror-Beginner-Friendly-oror-Easy-to-Understand

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int jump = stones[i] - stones[j];
                
                if (jump <= j + 1) {
                    dp[i][jump] = dp[j][jump - 1] || dp[j][jump] || dp[j][jump + 1];
                    if (i == n - 1 && dp[i][jump]) return true;
                }
            }
        }
        return false;
    }
}