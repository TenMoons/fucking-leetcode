/**
 * 109. 有序链表转换二叉搜索树
 */

public class Solution_109 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 快慢指针找中点，从中点分割
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head, pre = null;  // pre用于标记中点的前驱
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // 断开左子表的链接，变成新链表
        pre.next = null;
        // slow指向中点
        TreeNode root = new TreeNode(slow.val);
        // 构造左右子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

//    法二：利用List分割
//    public TreeNode sortedListToBST(ListNode head) {
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        TreeNode root = new TreeNode(0);
//        if (list.size() == 0)
//            return null;
//        buildTree(root, list, 0, list.size() - 1);
//        return root;
//    }
//
//    private void buildTree(TreeNode root, ArrayList<Integer> list, int start, int end) {
//        if (end - start == 1) {
//            root.left = new TreeNode(list.get(start));
//            root.val = list.get(end);
//            return;
//        }
//        int mid = (start + end) / 2;
//        root.val = list.get(mid);
//        if (mid - start >= 1) {
//            root.left = new TreeNode(0);
//            buildTree(root.left, list, start, mid - 1);
//        }
//        if (end - mid >= 1) {
//            root.right = new TreeNode(0);
//            buildTree(root.right, list, mid + 1, end);
//        }
//    }
}
