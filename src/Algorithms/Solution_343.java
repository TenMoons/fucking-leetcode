package Algorithms;

/**
 * 343. 整数拆分
 */

public class Solution_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }

    // 数学方法
    public int integerBreak2(int n) {
        if (n <= 3)
            return n - 1;
        int quotient = n / 3;
        int mod = n % 3;
        int res = (int) Math.pow(3, quotient);
        if (mod == 0)
            return res;
        else if (mod == 1)
            return res / 3 * 4;
        else
            return res * 2;
    }

}