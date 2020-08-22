package queueandstack;

/**
 * 岛屿数量
 */

public class Solution_9 {
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
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int nextX = i + dirs[d][0];
            int nextY = j + dirs[d][1];
            if (validate(nextX, nextY) && !visited[nextX][nextY]) {
                dfs(grid, nextX, nextY);
            }
        }
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
