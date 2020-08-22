/**
 * 129. Sum Root to Leaf Numbers
 */

public class Solution_129 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return getPathSum(root, 0);
    }

    // 计算从root到某一个叶子结点的路径总和
    private int getPathSum(TreeNode root, int pathSum) {
        if (root == null)
            return 0;
        // 到当前节点的路径总和
        pathSum = pathSum * 10 + root.val;
        // 左子树的路径总和
        int leftSum = getPathSum(root.left, pathSum);
        // 右子树的路径总和
        int rightSum = getPathSum(root.right, pathSum);
        // 如果是叶子结点则返回到叶子节点的路径总和，否则返回左右子树路径总和
        return leftSum + rightSum == 0 ? pathSum : leftSum + rightSum;
    }
}
