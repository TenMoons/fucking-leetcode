package Algorithms;

/**
 * 968. 监控二叉树
 */

public class Solution_968 {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root) == 0 ? res + 1 : res;
    }

    // 后序遍历，因为当前节点的状态依赖于孩子结点
    // 0：未被覆盖(当前节点未被监控覆盖到)
    // 1：已被覆盖(摄像头已经监控到这个节点)
    // 2：需放置摄像头
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            // 左右孩子有一个没有被监控到
            res++;
            return 2;
        }
        if (left == 1 && right == 1) {
            // 左右孩子都被监控，则该结点不在范围
            return 0;
        } else {
            // 一个被监控，一个安装了摄像头，则该结点被监控到
            return 1;
        }
    }
}
