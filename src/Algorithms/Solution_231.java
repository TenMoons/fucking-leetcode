package Algorithms;

/**
 * 231.2的幂
 */

public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;  // 2的幂必定只有一个1（二进制
    }
}
