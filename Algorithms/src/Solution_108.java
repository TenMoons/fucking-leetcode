/**
 * 108. 将有序数组转换为二叉搜索树
 */

public class Solution_108 {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int x){
            val = x;
        }
    }

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        if (nums == null)
            return null;
        if (nums.length == 1)
            return new TreeNode(0);
        return insert(0, nums.length - 1);
    }

    // 将nums[left...right]插入树中, 根结点为mid = left +right / 2
    private TreeNode insert(int left, int right){
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode curRoot = new TreeNode(nums[mid]);
        curRoot.left = insert(left, mid - 1);
        curRoot.right = insert(mid + 1, right);
        return curRoot;
    }
}
