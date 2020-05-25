package LCOF;

/**
 * 面试题47. 礼物的最大价值
 */

public class Solution_47 {
    public int maxValue(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {  // 第一行，只能从左边累加
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {  // 第一列，只能从上方累加
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];  // 只能从上方，或左侧的格子过来
                }
            }
        }
        return dp[R - 1][C - 1];
    }

    // 原地修改 O(1)空间复杂度
    public int maxValue2(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {  // 第一行，只能从左边累加
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {  // 第一列，只能从上方累加
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);  // 只能从上方，或左侧的格子过来
                }
            }
        }
        return grid[R - 1][C - 1];
    }

}
