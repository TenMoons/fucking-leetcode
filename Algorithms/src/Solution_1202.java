import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1202. 交换字符串中的元素
 */

public class Solution_1202 {
    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            union(x, y);
        }
        for (int i = 0; i < s.length(); i++) {
            int parent = find(i);
            PriorityQueue<Character> queue = map.getOrDefault(find(i), new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(parent, queue);
        }
        for (int i = 0; i < s.length(); i++) {
            PriorityQueue<Character> q = map.get(find(i));
            sb.append(q.poll());
        }
        return sb.toString();
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return x;
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY)
            parent[parentY] = parentX;
    }
}
