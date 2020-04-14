package Algorithms;

/**
 * 72. 编辑距离
 */

public class Solution_72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j]:表示word1[0...i] -> word2[0...j]的最小编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];
        /**
         * base case
         * 其中一个字符串到达串首，则另一个字符串的操作是将剩余部分（长度为i/j）全部插入
         */
        for (int i = 1; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 1; j <= len2; j++)
            dp[0][j] = j;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 两个字符一样，什么也不做，直接跳过
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1,  // 删除word1[i]，前移i继续跟j比较
                            dp[i][j - 1] + 1),   // 在word1[i]插入与word2[j]一样的字符，前移j继续跟i比较
                            dp[i - 1][j - 1] + 1);  // 替换，把word1[i]替换为word2[j]，ij均前移继续比较
                }
            }
        }
        return dp[len1][len2];
    }
}
