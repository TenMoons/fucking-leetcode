package biweeklycontest.contest25;

import java.util.LinkedList;

/**
 * 5385. 改变一个整数能得到的最大差值
 */

public class Solution_1 {
    public int maxDiff(int num) {
        int maxVal = 0, minVal = 0;
        LinkedList<Integer> nums = new LinkedList<>();
        while (num != 0) {
            nums.addFirst(num % 10);
            num /= 10;
        }
        boolean isFirst;
        int firstVal = nums.get(0);
        // 求最大值的被替换位的值
        for (int i = 0; i < nums.size();i++) {
            if (nums.get(i) != 9) {
                firstVal = nums.get(i);
                break;
            }
        }
        // 求最大值
        for (int i = 0; i < nums.size(); i++) {
            int curVal = nums.get(i);
            if (curVal == firstVal) {
                curVal = 9;
            }
            maxVal = maxVal * 10 + curVal;
        }

        // 求最小值
        // 求最小值的被替换
        isFirst = false;
        boolean isFirstOne = false;
        if (nums.get(0) == 1) {  // 第一位为1
            isFirstOne = true;
        }
        if (isFirstOne) {  // 第一位为1，找到后面第一个不为1且不为0的
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) != 1 && nums.get(i) != 0) {
                    firstVal = nums.get(i);
                    break;
                }
            }
        }
        if (isFirstOne) {
            minVal = 1;
            for (int i = 1; i < nums.size(); i++) {
                int curVal = nums.get(i);
                if (curVal == firstVal) {
                    curVal = 0;
                }
                minVal = minVal * 10 + curVal;
            }
        } else {
            firstVal = nums.get(0);
            for (int i = 0; i < nums.size(); i++) {
                int curVal = nums.get(i);
                if (curVal == firstVal) {
                    curVal = 1;
                }
                minVal = minVal * 10 + curVal;
            }
        }
        return maxVal - minVal;
    }
}
