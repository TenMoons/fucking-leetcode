/**
 * 面试题26. 树的子结构
 */

public class Solution_26 {
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (isEqual(A, B))
            return true;  // 判断B是否是A根结点的子结构
        // 不是则判断B是否是A左右子树的子结构
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isEqual(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return isEqual(A.left, B.left) && isEqual(A.right, B.right);  // A.val == B.val，则判断左右子树是否均相等
    }
}

