package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */

public class Solution_199 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层次遍历(从右往左)
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);  // 将这一层最右端的元素加入list
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.right != null)
                    queue.offer(cur.right);
                if (cur.left != null)
                    queue.offer(cur.left);
            }
        }
        return res;
    }
}
