package Explore.arrayandstring;

/**
 * 旋转数组
 */

public class Solution_16 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return;
        k = k % nums.length;
        // 做k次单步移动
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    // 反转数组
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return;
        k = k % nums.length;  // 避免越界
        // 第一次反转后，有k个尾部元素到了头部
        reverse(nums, 0, nums.length - 1);
        // 恢复头部的新元素的顺序
        reverse(nums, 0, k - 1);
        // 恢复尾部的新元素的顺序
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // 环装交换
    public void rotate3(int[] nums, int k) {
        int cnt = 0;  // 已经rotate的元素的个数
        k = k % nums.length;
        for (int start = 0; cnt < nums.length; start++) {
            int curIndex = start;  // 当前访问元素的下标
            int prev = nums[curIndex];
            do {
                int nextIndex = (curIndex + k) % nums.length;
                int temp = nums[nextIndex];
                nums[nextIndex] = prev;  // prev移动k个位置
                curIndex = nextIndex;  // 下一个进行旋转的元素是被prev替代的元素
                prev = temp;
                cnt++;
            } while (curIndex != start);  // 若被替代的元素到了start位置，则向后顺延一个元素开始旋转
        }
    }
}
