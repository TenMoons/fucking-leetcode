/**
 * 222. Count Complete Tree Nodes
 */

public class Solution_222 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == right) {
            // 高度相等，说明左子树是满二叉树
            return (1 << left) + countNodes(root.right);
        }
        else {
            // 不相等，说明右子树是满二叉树
            return (1 << right) + countNodes(root.left);
        }
    }

    // 以node为根的树的高度
    private int height(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
