package Algorithms;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 */

public class Solution_887 {
    public int superEggDrop(int K, int N) {
        // dp[K][N]，在K个鸡蛋N层楼的条件下，最坏情况下最少的测试次数
        int[][] dp = new int[K + 1][N + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);
        return helper(K, N, dp);
    }

    private int helper(int K, int N, int[][] dp) {
        if (K == 1 || N == 0 || N == 1)
            return N;
        if (dp[K][N] != Integer.MAX_VALUE)
            return dp[K][N];
        int res = Integer.MAX_VALUE;
        // 二分查找
        int low = 1, high = N;
        while (low <= high) {
            // 在mid层扔鸡蛋
            int mid = low + (high - low) / 2;
            // 鸡蛋碎了，递增
            int broken = helper(K - 1, mid - 1, dp);
            // 鸡蛋没有碎，递减
            int unbroken = helper(K, N - mid, dp);
            if (broken > unbroken) {
                // 去下面的楼层扔
                high = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                // 去上面的楼层扔
                low = mid + 1;
                res = Math.min(res, unbroken + 1);
            }
        }
        return res;
    }

    // 另一种思路的DP
    public int superEggDrop2(int K, int N) {
        // 给定K个鸡蛋，最坏情况下最少扔m次，能测试的楼层数
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;  // dp[k][m - 1]没碎，dp[k - 1][m - 1] 碎了
        }
        return m;
    }
}
