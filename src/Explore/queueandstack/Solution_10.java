package Explore.queueandstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 */

public class Solution_10 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        if (node.neighbors.size() == 0)
            return new Node(node.val);
        // 存放原图与clone图结点的对应
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    // 从node开始dfs
    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);
        // 克隆当前节点node
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, visited));
        return clone;
    }
}
