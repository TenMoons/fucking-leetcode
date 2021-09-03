/**
 * 1109. 航班预订统计
 * @author TenMoons
 * @date 2021-09-03 23:18
 */
public class Solution_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            // 上车
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                // 下车
                res[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
