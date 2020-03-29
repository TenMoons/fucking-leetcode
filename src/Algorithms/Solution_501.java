package Algorithms;

import java.util.ArrayList;

/**
 * 501. 二叉搜索树中的众数
 */

public class Solution_501 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;  // 前一个访问的结点
        int cnt = 0, maxCnt = 0;
        // Morris遍历
        while (cur != null) {
            if (cur.left == null) {  // 左子树为空，则访问当前节点，然后进入右子树
                // 处理
                if (pre != null && pre.val == cur.val)  // 当前节点和上一个节点的val相同
                    cnt++;
                else
                    cnt = 0;  // 不同则清空，重新计数
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res.clear();
                    res.add(cur.val);
                } else if (cnt == maxCnt)  // 不止一个众数
                    res.add(cur.val);

                pre = cur;
                cur = cur.right;
            } else {  // 进入左子树，找cur的前驱
                TreeNode preceesor = cur.left;
                while (preceesor.right != null && preceesor.right != cur) {  // 没有遍历过
                    preceesor = preceesor.right;
                }
                if (preceesor.right == cur) {  // 前驱已经指向过自己，说明处理过，直接访问当前节点，然后进入右子树
                    // // 处理
                    if (pre != null && pre.val == cur.val)  // 当前节点和上一个节点的val相同
                        cnt++;
                    else
                        cnt = 0;  // 不同则清空，重新计数
                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                        res.clear();
                        res.add(cur.val);
                    } else if (cnt == maxCnt)  // 不止一个众数
                        res.add(cur.val);

                    pre = cur;
                    cur = cur.right;
                    preceesor.right = null;  // 断开前驱到当前节点的链接
                } else {  // 前驱没有指向自己，说明左子树没有遍历过，进行链接，然后进入左子树
                    preceesor.right = cur;
                    cur = cur.left;
                }
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = res.get(i);
        return array;
    }
}
