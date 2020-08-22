/**
 * 面试题 64. 求1+2+…+n
 */

public class Solution_64 {
    private int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
