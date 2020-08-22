package queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */

public class Solution_2 {
    // 4-邻接点
    private int[][] dirs = new int[][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    // 是否访问过
    private boolean[][] visited;
    private int R;
    private int C;

    public int numIslands(char[][] grid) {
        R = grid.length;
        if (R == 0)
            return 0;
        C = grid[0].length;
        visited = new boolean[R][C];
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int index = x * C + y;  // 映射为一维下标
        queue.offer(index);
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur = queue.poll();
            int curX = cur / C;
            int curY = cur % C;
            // 相邻节点入队
            for (int i = 0; i < size; i++) {
                for (int d = 0; d < 4; d++) {
                    int nextX = curX + dirs[d][0];
                    int nextY = curY + dirs[d][1];
                    if (validate(nextX, nextY) && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                        queue.offer(nextX * C + nextY);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
