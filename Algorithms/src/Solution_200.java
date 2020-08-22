/**
 * 200.岛屿数量
 * 通过dfs统计连通分量个数
 */

public class Solution_200 {
    private int R, C;
    private char[][] grid;
    private int[][] dirs = new int[][]{  // 4-邻接点坐标关系
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
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
                if (!visited[i][j] && grid[i][j] == '1') {  // 只对陆地遍历
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }

    // 以(x, y)为起始点进行dfs
    private void dfs(int x, int y){
        visited[x][y] = true;
        for (int d = 0; d < 4; d++){
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == '1'){
                dfs(nextX, nextY);
            }
        }
    }

    // 判断(x, y)是否合法
    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
