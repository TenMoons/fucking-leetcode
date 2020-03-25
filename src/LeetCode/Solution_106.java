package LeetCode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */

public class Solution_106 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
            return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd)
            return null;
        // 建立根节点
        TreeNode curRoot = new TreeNode(postorder[pEnd]);
        int index = 0;
        // 找到根节点在inorder中的下标，区分左右子树
        while (postorder[pEnd] != inorder[iStart + index])
            index++;
        // 建立左右子树
        curRoot.left = helper(inorder, iStart, iStart + index - 1, postorder, pStart, pStart + index - 1);
        curRoot.right = helper(inorder, iStart + index + 1, iEnd, postorder, pStart + index, pEnd - 1);
        return curRoot;
    }
}
