package queueandstack;

import java.util.Arrays;

/**
 * 完全平方数
 */

public class Solution_4 {
    public int numSquares(int n) {
        // 组成n的完全平方数的数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);  // +1是因为dp[j * j] = 1
            }
        }
        return dp[n];
    }
}
