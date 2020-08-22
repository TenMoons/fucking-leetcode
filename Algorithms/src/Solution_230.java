import java.util.ArrayList;
import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 */

public class Solution_230 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        traversal(root);
        return list.get(k - 1);
    }

    // 中序遍历
    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }

    // 非递归实现
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int cnt = 0;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                cnt++;
                if (cnt == k)
                    return root.val;
                root = root.right;
            }
        }
        return 0;
    }
}
