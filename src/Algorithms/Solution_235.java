package Algorithms;

/**
 * 235. 二叉搜索树的最近公共祖先
 */

public class Solution_235 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // pq都在当前节点的左侧
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        // pq都在当前节点的右侧
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        // 异侧
        else
            return root;
    }
}
