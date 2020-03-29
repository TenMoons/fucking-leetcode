package Algorithms;

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
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val){
            if (isSymmetric(p.left, q.right)){
                return isSymmetric(p.right, q.left);
            }
        }
        return false;
    }
}
