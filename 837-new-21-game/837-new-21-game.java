//https://leetcode.com/problems/new-21-game/discuss/3561141/Solution-in-Java-(3ms)

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double sum = 1.0, res = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) sum += dp[i];
            else res += dp[i];
            if (i - maxPts >= 0) sum -= dp[i - maxPts];
        }

        return res;
    }
}