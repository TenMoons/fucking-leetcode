package contest206;

import java.util.PriorityQueue;

public class Solution {
    // 1.二进制矩阵中的特殊位置
    public int numSpecial(int[][] mat) {
        int res = 0;
        int row = mat.length, col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    boolean flag = true;
                    for (int k = 0; k < col; k++) {
                        if (k == j) {
                            continue;
                        }
                        if (mat[i][k] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    for (int k = 0; k < row; k++) {
                        if (k == i) {
                            continue;
                        }
                        if (mat[k][j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        res++;
                }
            }
        }
        return res;
    }

    // 3.连接所有点的最小费用
    // 并查集
    class UF {
        int[] parent;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] dis = new int[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                dis[o1[0]][o1[1]] - dis[o2[0]][o2[1]]);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                dis[i][j] = dis[j][i] = d;
                queue.add(new int[] {i, j});
            }
        }
        UF uf = new UF(n);
        int res = 0;
        while (!queue.isEmpty() && n != 0) {
            int[] tmp = queue.poll();
            if (!uf.isConnected(tmp[0], tmp[1])) {
                res += dis[tmp[0]][tmp[1]];
                uf.union(tmp[0], tmp[1]);
            }
        }
        return res;
    }


}
