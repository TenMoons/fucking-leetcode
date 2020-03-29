package Algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 */

public class Solution_107 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.offerFirst(level);  // 从头部插入
        }
        return res;
    }
}
