/**
 * 面试题 54. 二叉搜索树的第k大节点
 */

public class Solution_54 {
    class TreeNode{
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;
    private int cnt = 0;

    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    // 中序遍历：先右后左则是降序
    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.right, k);
        if (++cnt == k) {
            res = root.val;
        }
        inOrder (root.left, k);
    }
}
