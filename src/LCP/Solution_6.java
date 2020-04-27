package LCP;

/**
 * LCP 06. 拿硬币
 */

public class Solution_6 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += Math.ceil((double)coin / 2.0);
        }
        return res;
    }
}
