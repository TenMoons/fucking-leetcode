package interview1;

/**
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，
 * 你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
 * 但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。
 * 答案可能非常大，返回 结果 mod 109 + 7 的值。
 */

public class Solution_2 {
    private int[][] dirs = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    // 动态规划
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0)
            return 0;
        int mod = 1000000007;
        int[][][] dp = new int[m][n][N + 1];  // dp[i][j][k] 表示从(i, j)开始在k步内移出边界的路径数
        // 枚举所有路径数
        for (int k = 1; k <= N; ++k){
            for (int row = 0; row < m; ++row){
                for (int col = 0; col < n; ++col){
                    for (int[] dir : dirs){
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        // 出界
                        if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n){
                            dp[row][col][k] += 1;
                        }
                        else{
                            // 从[row, col]移动到[nextRow, nextCol]需要花费一步
                            dp[row][col][k] = (dp[row][col][k] + dp[nextRow][nextCol][k - 1]) % mod;
                        }
                    }
                }
            }
        }
        return dp[i][j][N];
    }
}
