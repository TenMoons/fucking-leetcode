import java.util.ArrayList;
import java.util.HashMap;

/**
 * 508. 出现次数最多的子树元素和
 */

public class Solution_508 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int maxCnt = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        dfs(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCnt)
                list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = dfs(root.left);  // 左子树元素和
        int rightSum = dfs(root.right);  // 右子树元素和
        int curSum = root.val + leftSum + rightSum;  // 当前节点的子树元素和
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);  // 次数+1
        maxCnt = Math.max(maxCnt, map.get(curSum));  // 更新最值
        return curSum;
    }
}
