package interview.interview6;

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {
    // 并查集
    class UFS {
        int[] parent;
        public UFS(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;  // 先指向自身
        }

        public int find(int e) {
            if (parent[e] != e)
                parent[e] = find(parent[e]);
            return parent[e];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public int removeStones(int[][] stones) {
        UFS ufs = new UFS(20000);
        // 合并行和列
        for (int[] stone : stones) {
            ufs.union(stone[0], stone[1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(ufs.find(stone[0]));
        }
        return stones.length - set.size();
    }


}
