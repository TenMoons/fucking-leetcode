/**
 * 面试题43. 1～n整数中1出现的次数
 */

public class Solution_43_1 {
    public int countDigitOne(int n) {
        return func(n);
    }

    private int func(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        return high == 1 ? func(pow - 1) + last + 1 + func(last)
                : high * func(pow - 1) + pow + func(last);
    }
}
