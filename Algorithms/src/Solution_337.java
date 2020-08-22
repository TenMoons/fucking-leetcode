/**
 * 337. 打家劫舍 III
 */

public class Solution_337 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 树形dp
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    // 返回值dp[0]表示不选root的rob_sum
    // 返回值dp[1]表示选root的rob_sum
    private int[] dp(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // root抢了，则不能抢其直接左右孩子
        int rob_sum = root.val + left[0] + right[0];
        // rob没有抢，则其直接左右孩子可抢可不抢
        int not_rob_sum = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {not_rob_sum, rob_sum};
    }
}
