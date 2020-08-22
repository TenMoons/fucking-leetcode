import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */

public class Solution_173 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 队列实现，提前遍历
    class BSTIterator {
        Queue<Integer> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            traversal(root);  // 中序遍历
        }

        private void traversal(TreeNode node) {
            if (node == null)
                return;
            traversal(node.left);
            queue.offer(node.val);
            traversal(node.right);
        }

        /** @return the next smallest number */
        public int next() {
            return queue.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    // 栈实现，不用提前遍历
    class BSTIterator2 {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator2(TreeNode root) {
            add(root);
        }

        private void add(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = stack.pop();
            if (cur.right != null)
                add(cur.right);
            return cur.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
