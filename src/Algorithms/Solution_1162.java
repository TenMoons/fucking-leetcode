package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 */

public class Solution_1162 {
    private int R;
    private int C;
    private int[][] dirs = new int[][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int maxDistance(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 初始化
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == 1)  // 陆地入队
                    queue.offer(new int[]{i, j});
        boolean hasOcean = false;
        int[] ocean = null;
        while (!queue.isEmpty()) {
            ocean = queue.poll();
            int x = ocean[0];
            int y = ocean[1];
            // 4-邻接点的海洋入队
            for (int d = 0; d < 4; d++) {
                int nextX = x + dirs[d][0];
                int nextY = y + dirs[d][1];
                if (validate(nextX, nextY) && grid[nextX][nextY] == 0) {
                    hasOcean = true;
                    grid[nextX][nextY] = grid[x][y] + 1;  // 直接修改grid来表示距离，不用额外空间
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return !hasOcean || ocean == null ? -1 : grid[ocean[0]][ocean[1]] - 1;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
