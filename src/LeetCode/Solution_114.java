package LeetCode;

/**
 * 114. 二叉树展开为链表
 */

public class Solution_114 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                // 如果左子树不为空, 那么就先找到左子树的最右节点(当前节点的前驱
                TreeNode pre = root.left;
                while (pre.right != null)
                    pre = pre.right;
                // 将当前节点的右孩子放到最右节点的右子树上
                pre.right = root.right;
                // 将左孩子移到右孩子方便循环
                root.right = root.left;
                // 将左孩子置为空
                root.left = null;
            }
            root = root.right; // 继续下一个节点
        }
        return;
    }
}
