import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 */

public class Solution_32_3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 标记打印方向
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            if (flag) {
                // 奇数层，从左到右。取出头部元素，将左右子树加入队尾
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollFirst();
                    level.add(cur.val);
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                }
            } else {
                // 偶数层，从右到左。取出尾部元素，将左右子树加入队首
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollLast();
                    level.add(cur.val);
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                }
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
