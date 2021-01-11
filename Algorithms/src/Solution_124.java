/**
 * 124. 二叉树中的最大路径和
 */

public class Solution_124 {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxPathSum(root.left));
        int rightSum = Math.max(0, maxPathSum(root.right));

        res = Math.max(res, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
