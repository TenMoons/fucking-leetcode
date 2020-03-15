package LeetCode;

/**
 * 104.二叉树的最大深度
 * dfs
 */

public class Solution_104 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
