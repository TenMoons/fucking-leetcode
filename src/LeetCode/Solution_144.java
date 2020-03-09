package LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_144 {
    public static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int v){
            val = v;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if(root.right != null)
                stack.push(root.right);
            if(root.left != null)
                stack.push(root.left);
        }
        return list;
    }
}
