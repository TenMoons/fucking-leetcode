import java.util.Arrays;
import java.util.Comparator;

/**
 * 1288. 删除被覆盖区间
 */

public class Solution_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end && intervals[i][1] <= end) {
                cnt++;
            } else if (intervals[i][0] <= end && intervals[i][1] > end) {
                end = intervals[i][1];
            } else {
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
