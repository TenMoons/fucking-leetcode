package Algorithms;

/**
 * 278. 第一个错误的版本
 */

public class Solution_278 {
    int badVersion;

    public int firstBadVersion(int n) {
        if (n == 1)
            return n;
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            boolean ans = isBadVersion(mid);
            if (!ans)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    boolean isBadVersion(int version) {
        return badVersion == version;
    }
}
