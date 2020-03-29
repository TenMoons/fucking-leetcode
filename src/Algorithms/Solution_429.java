package Algorithms;

/**
 * N叉树的层序遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_429 {
    class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int thisNum = queue.size();
            ArrayList<Integer> thisLevel = new ArrayList<>();
            for (int i = 0; i < thisNum; i++){
                Node cur = queue.poll();
                thisLevel.add(cur.val);
                for (Node item : cur.children)
                    queue.add(item);
            }
            res.add(thisLevel);
        }
        return res;
    }
}
