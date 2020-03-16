package LeetCode;

/**
 * 110.平衡二叉树
 */

public class Solution_110 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    /* 自顶向下 */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = getHeight(root.left);  // 左子树高度
        int right = getHeight(root.right);  // 右子树高度
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root){
        return getHeight2(root) != -1;
    }

    // 获取高度的同时判断是否平衡
    public int getHeight2(TreeNode root){
        if (root == null)
            return 0;
        int left = getHeight2(root.left);
        if (left == -1)
            return -1;
        int right = getHeight2(root.right);
        if (right == -1)
            return  -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
