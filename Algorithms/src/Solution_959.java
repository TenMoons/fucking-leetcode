/**
 * 959. 由斜杠划分区域
 */

public class Solution_959 {
    private int[][] dirs = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] graph = new boolean[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    graph[3 * i][3 * j + 2] = true;
                    graph[3 * i + 1][3 * j + 1] = true;
                    graph[3 * i + 2][3 * j] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    graph[3 * i][3 * j] = true;
                    graph[3 * i + 1][3 * j + 1] = true;
                    graph[3 * i + 2][3 * j + 2] = true;
                }
            }
        }
        // 转换为统计graph中false的连通分量的数
        int res = 0;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (!graph[i][j]) {
                    dfs(graph, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] graph, int x, int y) {
        graph[x][y] = true;
        int n = graph.length;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !graph[nextX][nextY]) {
                dfs(graph, nextX, nextY);
            }
        }
    }
}
