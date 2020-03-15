package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091.二进制矩阵中的最短路径
 * BFS
 */

public class Solution_1091 {
    private int[][] dirs = new int[][]{  // 八连通邻接点
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };
    private int R, C;
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid.length;
        visited = new boolean[R][C];
        int[][] distance = new int[R][C];  // 到每一个顶点所找到的最短路径的值
        if (grid[0][0] == 1 || grid[R - 1][C - 1] == 1)
            return -1;
        if (R == 1 && C == 1)
            return 1;

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0][0] = true;
        distance[0][0] = 1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            // 一维映射到二维
            int curX = cur / C;
            int curY = cur % C;
            // 检查八连通节点
            for (int d = 0; d < 8; d++){
                int nextX = curX + dirs[d][0];
                int nextY = curY + dirs[d][1];
                if (validate(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0){
                    queue.offer(nextX * C + nextY);
                    visited[nextX][nextY] = true;
                    distance[nextX][nextY] = distance[curX][curY] + 1;
                    // 是否到终点
                    if (nextX == R - 1 && nextY == C - 1)
                        return distance[nextX][nextY];
                }
            }
        }
        return -1;
    }

    private boolean validate(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
