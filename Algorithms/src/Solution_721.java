import java.util.*;

/**
 * 721. 账户合并
 */

public class Solution_721 {
    class UF{
        int[] parent;
        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            parent[rootX] = rootY;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();  // 邮箱到人的映射，value为下标
        int n = accounts.size();
        UF uf = new UF(n);
        for (int i = 0;i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {  // 邮箱已出现过，则合并人的下标
                    int index = map.get(email); // 之前的下标
                    uf.union(index, i);  // 将之前的下标和当前下标合并
                }
                map.put(email, i);
            }
        }
        HashMap<Integer, Set<String>> map2 = new HashMap<>();  // 人的下标到邮箱集合的映射
        for (int i = 0; i < n; i++) {
            int index = uf.find(i);
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());  // 邮箱列表
            if (map2.containsKey(index)) {
                map2.get(index).addAll(emails);
            } else {
                map2.put(index, new TreeSet<>(emails));
            }
        }
        // 下标转换为人名
        for (Map.Entry<Integer, Set<String>> entry : map2.entrySet()) {
            List<String> tmp = new ArrayList<>();
            int index = entry.getKey();
            tmp.add(accounts.get(index).get(0));  // 添加人名
            tmp.addAll(entry.getValue());
            res.add(tmp);
        }
        return res;
    }
}
