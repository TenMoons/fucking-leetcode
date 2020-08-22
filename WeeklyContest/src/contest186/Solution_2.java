package contest186;

public class Solution_2 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int left = n - k;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++)
            dp[i + 1] = dp[i] + cardPoints[i];
        int res = Integer.MAX_VALUE;
        for(int i = left; i <= n; i++)
            res = Math.min(res, dp[i] - dp[i - left]);
        return dp[n] - res;
    }
}
