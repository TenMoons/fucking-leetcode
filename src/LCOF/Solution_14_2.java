package LCOF;

/**
 * 面试题14- II. 剪绳子 II
 */

public class Solution_14_2 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        long res = 1;
        while (n > 0) {
            int curLen = 3;
            if (n == 4) {
                curLen = 4;
            } else if (n == 2 || n == 1) {
                curLen = n;
            }
            res = (res * curLen) % 1000000007;
            n -= curLen;
        }
        return (int) res;
    }
}
