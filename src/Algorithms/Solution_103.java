package Algorithms;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 */

public class Solution_103 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cnt = 1;  // 统计层数
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.remove();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if (cnt < 0)
                Collections.reverse(level);  // 需要翻转的层
            res.add(level);
            cnt *= -1;
        }
        return res;
    }
}
