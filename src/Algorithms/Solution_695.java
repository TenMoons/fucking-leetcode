package Algorithms;

/**
 * 695. 岛屿的最大面积
 * floodfill算法
 */

public class Solution_695 {
    private int R, C;
    private int[][] grid;
    private int[][] dirs = new int[][]{  // 4-邻接点
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        R = grid.length;  // 行数
        if (R == 0)
            return  0;
        C = grid[0].length;
        if (C == 0)
            return 0;
        this.grid = grid;

        int res = 0;
        // dfs求连通分量
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (!visited[i][j] && grid[i][j] == 1) {  // 只对陆地遍历
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    // 以(x, y)为起始点进行dfs，在dfs过程中记录联通分量有多少顶点
    private int dfs(int x, int y){
        visited[x][y] = true;
        int res = 1;
        for (int d = 0; d < 4; d++){
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1){
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
