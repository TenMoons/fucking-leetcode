package Algorithms;

/**
 * 69. x 的平方根
 */

public class Solution_69 {
    public int mySqrt(int x) {
        long lo = 0;
        long hi = x / 2 + 1;
        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;
            long cur = mid * mid;
            if (cur > x) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return (int)lo;
    }

}
