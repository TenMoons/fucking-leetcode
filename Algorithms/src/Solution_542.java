import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 */

public class Solution_542 {
    // 4-邻接点
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private int R, C;

    // 从0搜索1(bfs)
    public int[][] updateMatrix(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 将0的坐标都添加进queue
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (matrix[i][j] == 0)
                    queue.add(new int[] {i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;

        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = pos[0] + dir[0];
                    int nextY = pos[1] + dir[1];
                    if (validate(nextX, nextY) && matrix[nextX][nextY] == Integer.MAX_VALUE) {
                        matrix[nextX][nextY] = matrix[pos[0]][pos[1]] + 1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        return matrix;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
