package LCOF;

/**
 * 面试题28. 对称的二叉树
 */

public class Solution_28 {
    class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        return false;
    }
}
