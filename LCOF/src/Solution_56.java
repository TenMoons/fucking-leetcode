import java.util.Arrays;

/**
 * 面试题56 - I. 数组中数字出现的次数
 */

public class Solution_56 {
    // 双指针
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int[] res = new int[2];
        int idx = 0;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                left = right + 1;
                right += 2;
            } else {
                res[idx++] = nums[left];
                left = right;
                right++;
            }
        }
        if (idx != 2) {
            res[1] = nums[left];
        }
        return res;
    }

    // 位运算
    public int[] singleNumbers2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int idx = 0;
        // 找到不同的那一个二进制位
        while ((sum & 1) == 0) {
            sum >>= 1;
            idx++;
        }
        // 根据不同的二进制位分组
        int n1 = 0, n2 = 0;
        for (int num : nums) {
            if ((num >> idx & 1) == 0)
                n1 ^= num;
            else
                n2 ^= num;
        }
        return new int[] {n1, n2};
    }
}
