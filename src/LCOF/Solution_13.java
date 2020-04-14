package LCOF;

/**
 * 面试题13. 机器人的运动范围
 */

public class Solution_13 {
    // 4-邻接点
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    private int res = 1;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;
        visited = new boolean[m][n];
        dfs(m, n, 0, 0, k);
        return res;
    }

    private void dfs(int m, int n, int x, int y, int k) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] &&
            countSum(nextX, nextY) <= k) {
                visited[nextX][nextY] = true;
                res++;
                dfs(m, n, nextX, nextY, k);
            }
        }
    }

    private int countSum(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }
}
