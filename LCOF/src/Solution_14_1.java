/**
 * 面试题14- I. 剪绳子
 */

public class Solution_14_1 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        int res = 1;
        while (n > 0) {
            int curLen = 3;
            if (n == 4) {
                curLen = 4;
            } else if (n == 2 || n == 1) {
                curLen = n;
            }
            res *= curLen;
            n -= curLen;
        }
        return res;
    }
}
