package interview.interview5;

import java.util.ArrayList;

public class Solution_0 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        TreeNode root = new TreeNode(0);
        if (list.size() == 0)
            return null;
        buildTree(root, list, 0, list.size() - 1);
        return root;
    }

    private void buildTree(TreeNode root, ArrayList<Integer> list, int start, int end) {
        if (end - start == 1) {
            root.left = new TreeNode(list.get(start));
            root.val = list.get(end);
            return;
        }
        int mid = (start + end) / 2;
        root.val = list.get(mid);
        if (mid - start >= 1) {
            root.left = new TreeNode(0);
            buildTree(root.left, list, start, mid - 1);
        }
        if (end - mid >= 1) {
            root.right = new TreeNode(0);
            buildTree(root.right, list, mid + 1, end);
        }
    }
}
