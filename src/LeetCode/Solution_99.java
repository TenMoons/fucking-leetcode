package LeetCode;

/**
 * 99. 恢复二叉搜索树
 */

public class Solution_99 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public void recoverTree(TreeNode root) {
        TreeNode first = null;  // first和second用于找逆序的数字
        TreeNode second = null;
        TreeNode cur = root;
        TreeNode pre_new = null;
        while (cur != null) {
            // 当前节点左子树为空，则没有前驱节点，进入右孩子
            if (cur.left == null) {
                // 找逆序对
                if (pre_new != null && cur.val < pre_new.val) {
                    if (first == null) {
                        first = pre_new;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre_new = cur;
                cur = cur.right;  // 进入右孩子
            } else {
                // Morris中序遍历
                // 查找当前节点的前驱节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 若前驱节点的右子树为空，将前驱节点的right指向当前节点，然后进入当前节点的左孩子
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // 若前驱节点的right指向当前节点，则说明已经访问过，将right置空，然后进入右孩子
                if (pre.right == cur) {
                    pre.right = null;
                    // 找逆序对
                    if (pre_new != null && cur.val < pre_new.val) {
                        if (first == null) {
                            first = pre_new;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre_new = cur;
                    cur = cur.right;  // 进入右孩子
                }
            }
        }
        // 交换逆序对: first和second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
