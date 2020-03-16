package LeetCode;

/**
 * 101.对称二叉树
 */

public class Solution_101 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return  isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
