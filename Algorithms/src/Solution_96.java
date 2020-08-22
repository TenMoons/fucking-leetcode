/**
 * 96.不同的二叉搜索树
 */

public class Solution_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        if (n == 1)
            return 1;
        dp[2] = 2;
        // 长度为1...n的情况
        for (int i = 3; i <= n; i++) {
            // 以j为根结点
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_96().numTrees(3));
        System.out.println(new Solution_96().numTrees(4));
    }
}
