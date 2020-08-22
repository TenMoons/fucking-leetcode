/**
 * 718. 最长重复子数组
 */

public class Solution_718 {
    public int findLength(int[] A, int[] B) {
        // dp[i][j]表示以A[i],B[j]结尾的子数组中公共部分的最大长度
        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
