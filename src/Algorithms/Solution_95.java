package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 */

public class Solution_95 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) { val = x; }
    }

    // 递归求解
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0)
            return res;
        return generateTree(1, n);  // 生成1...n的所有树
    }

    private List<TreeNode> generateTree(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();
        // 没有节点，添加null
        if (start > end) {
            res.add(null);
            return res;
        }
        // 只有一个节点，添加该节点
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        // 从start...end顺序列举每个数作为根结点的情况
        for (int i = start; i <= end; i++) {
            // start...i-1作为左子树的所有情况,leftTrees包含每种情况的左子树根结点
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            // i+1...end作为右子树的所有情况,rightTrees包含每种情况的右子树根结点
            List<TreeNode> rightTrees = generateTree(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curRoot = new TreeNode(i);  // i作为根结点
                    curRoot.left = leftTree;
                    curRoot.right = rightTree;
                    res.add(curRoot);
                }
            }
        }
        return res;
    }

    // 动态规划求解
    public List<TreeNode> generateTrees2(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0)
            return dp[0];
        dp[0].add(null);
        // 只关注1...n的情况，其他都为同构
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();  // 长度为len的树的所有情况
            // 列举根结点为1...len的情况
            for (int curRoot = 1; curRoot <= len; curRoot++) {
                int left = curRoot - 1;  // 左子树的长度为curRoot - 1
                int right = len - curRoot;  // 右子树的长度为len - curRoot
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode root = new TreeNode(curRoot);
                        root.left = leftTree;  // 左子树可以共享，不用复制
                        root.right = clone(rightTree, curRoot);  // 右子树加上偏差
                        dp[len].add(root);
                    }
                }
            }
        }
        return dp[n];  // 返回长度为n的情况
    }

    // 复制树
    private TreeNode clone(TreeNode root, int offset) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}
