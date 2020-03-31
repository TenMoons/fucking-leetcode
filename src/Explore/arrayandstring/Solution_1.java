package Explore.arrayandstring;

/**
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */

public class Solution_1 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int[] numSum = new int[nums.length];  // 存放到当前元素时，其左边的元素和(包括自身
        numSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numSum[i] = numSum[i - 1] + nums[i];
        }
        // 检查是否有中心索引元素
        for (int i = 0; i < nums.length; i++) {
            if (numSum[i] - nums[i] == numSum[nums.length - 1] - numSum[i])  // 左右相等
                return i;
        }
        return -1;
    }
}
