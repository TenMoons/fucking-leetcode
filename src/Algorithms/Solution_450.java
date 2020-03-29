package Algorithms;

/**
 * 450. 删除二叉搜索树中的节点
 */

public class Solution_450 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val < key) {  // key在root右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {  // key在root左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else {  // 找到了对应节点

            if (root.left == null) {  // 左子树为空
                return root.right;
            } else if (root.right == null) {  // 右子树为空
                return root.left;
            } else {  // 左右子树都不为空，返回当前节点的后继节点作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    // 查找以root为根的树中的最小节点
    private TreeNode min(TreeNode root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    // 删除以root为根的树中的最小节点，并返回删除后的树根
    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

}
