package LCOF;

/**
 * 面试题10- I. 斐波那契数列
 */

public class Solution_10_1 {
    public int fib(int n) {
        int mod = 1000000007;
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
