/**
 * 面试题27. 二叉树的镜像
 */

public class Solution_27 {
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}

