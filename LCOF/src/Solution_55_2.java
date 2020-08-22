/**
 * 面试题 55 - II. 平衡二叉树
 */

public class Solution_55_2 {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 获取高度的同时判断是否平衡
    public int getHeight(TreeNode root){
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        if (left == -1)
            return -1;
        int right = getHeight(root.right);
        if (right == -1)
            return  -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
