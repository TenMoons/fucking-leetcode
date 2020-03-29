package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */

public class Solution_113 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        getPath(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void getPath(TreeNode root, int sum, List<List<Integer>> list, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        int leftSum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (leftSum == 0)
                list.add(path);
            return;
        }
        getPath(root.left, leftSum, list, new ArrayList<>(path));  // 左子树的路径
        getPath(root.right, leftSum, list, new ArrayList<>(path));  // 右子树的路径
    }
}
