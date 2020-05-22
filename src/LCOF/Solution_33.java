package LCOF;

/**
 * 面试题 33. 二叉搜索树的后序遍历序列
 */

public class Solution_33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0)
            return true;
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int lo, int hi) {
        if (lo >= hi) {
            return true;
        }
        int root = postorder[hi];
        int split = hi - 1;
        while (split >= lo) {
            if (postorder[split] < root) {  // 找到第一个比根结点小的，作为左右子树分离点
                for (int i = lo; i <= split; i++) {  // 检查一下左子树是不是都比root小，不是则直接返回false
                    if (postorder[i] > root) {
                        return false;
                    }
                }
                break;
            }
            split--;
        }
        return helper(postorder, lo, split) && helper(postorder, split + 1, hi - 1);
    }
}
