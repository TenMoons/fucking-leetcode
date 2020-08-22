import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 34. 二叉树中和为某一值的路径
 */

public class Solution_34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        backtrack(res, new LinkedList<Integer>(), root, sum);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> list, TreeNode cur,  int sum) {
        if (cur == null) {
            return;
        }
        list.add(cur.val);
        sum -= cur.val;
        if (sum == 0 && cur.left == null && cur.right == null) {
            res.add(new LinkedList<>(list));
        }
        // 左子树路径和
        backtrack(res, list, cur.left, sum);
        // 右子树路径和
        backtrack(res, list, cur.right, sum);
        // 撤销选择
        list.removeLast();
    }
}
