/**
 * 112.路径总和
 */

public class Solution_112 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        // 到达根结点
        if (root.left == null && root.right == null)
            return sum - root.val == 0;  // 路径总和是否满足sum
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
