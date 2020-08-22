/**
 * 404. 左叶子之和
 */

public class Solution_404 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        return getSum(root, root);
    }

    private int getSum(TreeNode pre, TreeNode cur) {
        if (cur == null)
            return 0;
        // 到达左叶子节点
        if (cur.left == null && cur.right == null && cur == pre.left)
            return cur.val;
        pre = cur;
        return getSum(pre, cur.left) + getSum(pre, cur.right);
    }
}
