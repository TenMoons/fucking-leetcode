/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author TenMoons
 * @date 2021-09-03 23:18
 */
public class Solution_993 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        return getHeight(root, x, 0) == getHeight(root, y, 0) && findParent(root, x, y);
    }

    int getHeight(TreeNode root, int target, int cur) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            return cur;
        }
        int left = getHeight(root.left, target, cur + 1);
        int right = getHeight(root.right, target, cur + 1);
        return left == -1 ? right : left;
    }

    boolean findParent(TreeNode root, int x, int y) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y ||
                    root.left.val == y && root.right.val == x) {
                return false;
            }
        }
        return findParent(root.left, x, y) && findParent(root.right, x, y);
    }
}
