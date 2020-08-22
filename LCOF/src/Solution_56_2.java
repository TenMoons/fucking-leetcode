/**
 * 面试题 56 - II. 数组中数字出现的次数 II
 */

public class Solution_56_2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & 1 << i) > 0) {
                    cnt++;
                }
            }
            if (cnt % 3 == 1) {
                res ^= (1 << i);
            }
        }
        return res;
    }
}
