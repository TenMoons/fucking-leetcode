import java.util.Arrays;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt = 0;
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        int pre = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (pre == -1 || intervals[i][0] >= intervals[pre][1]) {
                pre = i;
                continue;
            } else {
                cnt++;
                intervals[pre][1] = Math.min(intervals[i][1], intervals[pre][1]);
            }
        }
        return cnt;
    }
}
