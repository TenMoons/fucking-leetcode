package Algorithms;

/**
 * 236. 二叉树的最近公共祖先
 */

public class Solution_236 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        // 去左子树寻找祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 去右子树寻找祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return null;
    }
}
