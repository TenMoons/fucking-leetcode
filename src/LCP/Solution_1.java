package LCP;

/**
 * LCP 01. 猜数字
 */

public class Solution_1 {
    public int game(int[] guess, int[] answer) {
        int idx = 0;
        int res = 0;
        while (idx < 3) {
            if (guess[idx] == answer[idx])
                res++;
            idx++;
        }
        return res;
    }
}
