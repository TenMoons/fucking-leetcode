package Algorithms;

/**
 * 365.水壶问题
 */

public class Solution_365 {
    // 数学方法解题
    public boolean canMeasureWater(int x, int y, int z) {
        // 两个桶全部装满也无法满足z
        if (x + y < z)
            return false;
        // 特殊情况
        if (x == 0 || y == 0)
            return z == 0 || x + y == z;
        // 裴蜀定理：ax + by = z 有解 当且仅当 z % gcd(x, y) == 0
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
