package Algorithms;

/**
 * 1319. 连通网络的操作次数
 */

public class Solution_1319 {
    // 并查集
    class UF {
        public int[] parent;
        public int[] size;
        public int count;  // 联通分量个数

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            // 初始化
            for (int i = 0;i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        // 查找x所属树的根结点
        public int find(int x) {
            while (parent[x] != x) {
                x = find(parent[x]);
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;

            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length == 1)
            return 0;
        UF uf = new UF(n);
        int more = 0;  // 多出来的可用电缆
        for (int[] connection : connections) {
            if (!uf.isConnected(connection[0], connection[1]))
                uf.union(connection[0], connection[1]);
            else
                more++;
        }
        // 全部连通
        if (uf.count == 1)
            return 0;
        // 需要的电缆数量
        // uf.count - 1表示剩余的未连接的计算机数量x，连通它们需要x - 1根电缆
        // 再与已有网络连接需要1根，总共x根
        int left = uf.count - 1;
        return left > more ? -1 : left;
    }
}
