package LeetCode;

/**
 * 437. 路径总和 III
 */

public class Solution_437 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    // 从当前节点向根结点前进，计算路径和满足sum的路径数
    private int pathSum(TreeNode root, int sum, int[] nodes, int cur) {
        if (root == null)
            return 0;
        nodes[cur] = root.val;
        int pathSum = 0;
        int cnt = 0;
        for (int i = cur; i >= 0; i--) {
            pathSum += nodes[i];
            if (pathSum == sum)
                cnt++;
        }
        return cnt + pathSum(root.left, sum, nodes, cur + 1) + pathSum(root.right, sum, nodes, cur + 1);
    }
}
