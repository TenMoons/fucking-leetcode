package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 */

public class Solution_994 {
    private int R;
    private int C;
    private int[][] dirs = new int[][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();  // 存放腐烂橘子的坐标{x, y}
        int cnt = 0;  // 新鲜橘子的数量
        // 初始化
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1)   // 新鲜橘子
                    cnt++;
                else if (grid[i][j] == 2)  // 腐烂橘子
                    queue.offer(new int[]{i, j});
            }
        int minute = 0;
        while (cnt > 0 && !queue.isEmpty()) {
            minute++;
            int size = queue.size();
            while (size-- > 0) {
                int[] orange = queue.poll();
                int x = orange[0];
                int y = orange[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dirs[i][0];
                    int nextY = y + dirs[i][1];
                    // 4-邻接点是新鲜橘子，可以腐烂
                    if (validate(nextX, nextY) && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        cnt--;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return cnt > 0 ? -1 : minute;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
