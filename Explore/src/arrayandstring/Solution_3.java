package arrayandstring;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

public class Solution_3 {
    // 简单模拟
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1] ++;  // plus one
        int idx = len - 1;
        boolean overflow = false;  // 首位的进位符
        int[] res = new int[len + 1];
        while (idx >= 0 && digits[idx] > 9) {  // 进位
            digits[idx] = 0;
            if (idx != 0) {
                digits[idx - 1] ++;
            } else {
                overflow = true;
                res[0] = 1;
                for (int i = 1; i < len + 1; i++)
                    res[i] = digits[i - 1];
            }
            idx--;
        }
        return overflow ? res : digits;
    }

    // 直接找+1的位置，找不到说明是在首位，发生溢出，新建一个数组返回
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] of = new int[digits.length + 1];
        of[0] = 1;
        return of;
    }
}
