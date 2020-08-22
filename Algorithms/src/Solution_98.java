import java.util.ArrayList;

/**
 * 98.验证二叉搜索树
 */

public class Solution_98 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) { val = x; }
    }

    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        inOrder(root);
        if (list.size() == 1)
            return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }

    // 中序遍历以root为根的树
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
