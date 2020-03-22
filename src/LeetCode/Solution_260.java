package LeetCode;

/**
 * 260. 只出现一次的数字 III
 */

public class Solution_260 {
    // 根据二进制位进行区分，分为两组进行异或
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorRes = 0;
        // 异或的结果是只出现了一次的两个数的异或
        for (int x : nums) {
            xorRes ^= x;
        }
        // 根据xorRes进行分组
        int temp = 1;
        while (true) {
            if ((xorRes & 1) == 1)  // 两个数不同的位
                break;
            temp = temp << 1;
            xorRes = xorRes >> 1;
        }
        // 分组异或
        for (int num : nums) {
            if ((num & temp) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
