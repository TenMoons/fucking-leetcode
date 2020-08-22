/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。
 */

public class Solution_543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int length = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getPath(root);
        return length;
    }

    // 计算深度
    // 在求树的深度的过程中，保存左右子深度之和的最大值
    public int getPath(TreeNode root){
        if (root == null)
            return 0;
        int leftPath = getPath(root.left);
        int rightPath = getPath(root.right);
        length = Math.max(length, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_543().diameterOfBinaryTree(null));
    }
}
