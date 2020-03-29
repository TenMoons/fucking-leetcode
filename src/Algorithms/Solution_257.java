package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */

public class Solution_257 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, ArrayList<String> res) {
        if (root == null)
            return;
        path += root.val;
        // 到达叶子结点
        if (root.left == null && root.right == null)
            res.add(path);
        else {
            dfs(root.left, path + "->", res);
            dfs(root.right, path + "->", res);
        }
    }
}
