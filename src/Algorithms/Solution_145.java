package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_145 {
    public static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int v){
            val = v;
        }
    }

    //  左 右 中
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();  // 辅助栈
        ArrayList<Integer> list = new ArrayList<>();

        help.push(root);
        while(!help.isEmpty()){
            root = help.pop();
            stack.push(root);
            if(root.left != null)
                help.push(root.left);
            if(root.right != null)
                help.push(root.right);
        }
        while(!stack.isEmpty())
            list.add(stack.pop().val);
        return list;
    }
}
