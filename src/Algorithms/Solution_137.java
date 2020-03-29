package Algorithms;

/**
 * 137.只出现一次的数字 II
 */

public class Solution_137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int bitCnt = 0;  // 第i位的1出现了多少次，1出现的次数一定是3的倍数或者是1或者0
            for (int num : nums){
                bitCnt += (num >> i) & 1;
            }
            res ^= (bitCnt % 3) << i;  // 目标元素第i位的值
        }
        return res;
    }
}
