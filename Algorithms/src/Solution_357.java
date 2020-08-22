/**
 * 357. 计算各个位数不同的数字个数
 */

public class Solution_357 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];  // dp[i]表示i位数符号条件的个数
        dp[0] = 1;
        int fact = 9;
        int product = 9;
        for (int i = 1; i <= n; i++, fact--) {
            dp[i] += dp[i - 1] + product;
            product *= fact;
        }
        return dp[n];
    }

    // 优化
    public int countNumbersWithUniqueDigits2(int n) {
        int res = 1;
        int fact = 9;
        int product = 9;
        for (int i = 1; i <= n; i++, fact--) {
            res += product;
            product *= fact;
        }
        return res;
    }
}
