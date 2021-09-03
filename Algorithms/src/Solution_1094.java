/**
 * 1094. 拼车
 * @author TenMoons
 * @date 2021-09-03 23:14
 */
public class Solution_1094 {
    // 差分+前缀和记录人数变化
    public boolean carPooling(int[][] trips, int capacity) {
        int[] counters = new int[1001];
        for (int[] trip : trips) {
            counters[trip[1]] += trip[0];
            counters[trip[2]] -= trip[0];
        }
        for (int i = 0; i < 1000; i++) {
            counters[i + 1] += counters[i];
            if (counters[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
