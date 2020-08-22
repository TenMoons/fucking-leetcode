/**
 * 374. 猜数字大小
 */

public class Solution_374 {
    int res;

    public int guessNumber(int n) {
        if (n == 1)
            return 1;
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int ans = guess(mid);
            if (ans == 0) {
                return mid;
            } else if (ans == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    int guess(int num) {
        return Integer.compare(res, num);
    }
}
