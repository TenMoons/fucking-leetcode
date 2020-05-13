package Algorithms;

/**
 * 221. 最大正方形
 */

public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int m =  matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return  0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
