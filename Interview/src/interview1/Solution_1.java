package interview1;

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
 * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 */

public class Solution_1 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L || root.val > R) {  // 删除结点
            TreeNode leftRes = trimBST(root.left, L, R);
            TreeNode rightRes = trimBST(root.right, L, R);
            if (leftRes == null && rightRes == null)
                return null;
            else if (leftRes == null)
                return rightRes;
            else
                return leftRes;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
