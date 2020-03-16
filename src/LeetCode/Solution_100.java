package LeetCode;

/**
 * 100.相同的树
 */

public class Solution_100 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p.val == q.val) {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            }
        }
        return false;
    }
}
