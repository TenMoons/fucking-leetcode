/**
 * 684. 冗余连接
 */

public class Solution_684 {
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

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        int[] res = new int[2];
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        return res;
    }
}
