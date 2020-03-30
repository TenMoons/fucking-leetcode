package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */

public class Solution_513 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int res = 0;
    private int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        inOrder(root, 1);
        return res;
    }

    // 中序
    private void inOrder(TreeNode root, int level) {
        if (root == null)
            return;
        inOrder(root.left, level + 1);
        if (level > maxDepth) {  // 更新
            maxDepth = level;
            res = root.val;
        }
        inOrder(root.right, level + 1);
    }

    // 从右->左进行BFS
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;  // 最后一个遍历到的就是左下角的节点
    }
}
