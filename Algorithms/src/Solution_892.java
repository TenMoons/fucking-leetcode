/**
 * 892. 三维形体的表面积
 */

public class Solution_892 {
    private int row;
    private int col;
    private int[][] dirs = new int[][] {  // 邻接点的相对坐标
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int surfaceArea(int[][] grid) {
        int res = 0;
        if (grid.length == 0)
            return 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0)
                    res += (grid[i][j] << 2 + 2);  // grid[i][j]带来的表面积
                for (int x = 0; x < 4; x++) {
                    int nextX = i + dirs[x][0]; // 邻接点
                    int nextY = j + dirs[x][1];
                    if (validate(nextX, nextY) && grid[nextX][nextY] != 0) {
                        res -= Math.min(grid[i][j], grid[nextX][nextY]);  // 减去重复的面积
                    }
                }
            }
        }
        return res;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
