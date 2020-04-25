package interview.interview4;

public class Solution_1 {
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    private boolean[][] visited;
    private int R;
    private int C;
    private int res = 0;

    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        R = grid.length;  // 行数
        if (R == 0)
            return  0;
        C = grid[0].length;
        if (C == 0)
            return 0;
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (validate(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                dfs(grid, nextX, nextY);
            }
        }
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
