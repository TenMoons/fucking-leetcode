package queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 01矩阵
 */

public class Solution_17 {
    private int R, C;

    private int[][] dirs = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int[][] updateMatrix(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 初始化，把0的坐标都加入队列
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                for (int[] dir : dirs) {
                    int nextX = x + dir[0], nextY = y + dir[1];
                    // 初始matrix[nextX][nextY] == 1
                    if (validate(nextX, nextY) && matrix[nextX][nextY] == Integer.MAX_VALUE) {
                        matrix[nextX][nextY] = matrix[x][y] + 1;
                        queue.offer(new int[]{nextX, nextY});
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
