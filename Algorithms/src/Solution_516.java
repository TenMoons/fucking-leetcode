/**
 * 516. 最长回文子序列
 */

public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp的定义：在s[i...j]中，最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        // base case: 子序列长度为1
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        char[] arr = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;  // 长度+2
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);  // 两端分别加入子序列，取长度较大者
            }
        }
        return dp[0][n - 1];
    }
}
