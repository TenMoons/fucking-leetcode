package Algorithms;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */

public class Solution_105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd)
            return null;
        // 建立根节点
        TreeNode curRoot = new TreeNode(preorder[pStart]);
        // 找到根节点在inorder中的下标
        int index = 0;
        while (preorder[pStart] != inorder[iStart + index])
            index++;
        // 建立左右子树
        curRoot.left = helper(preorder, pStart + 1, pStart + index,
                inorder, iStart, iStart + index - 1);
        curRoot.right = helper(preorder, pStart + index + 1, pEnd,
                inorder, iStart + index + 1, iEnd);
        return curRoot;
    }
}
