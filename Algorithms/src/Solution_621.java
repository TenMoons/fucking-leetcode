import java.util.Arrays;

/**
 * 621. 任务调度器
 */

public class Solution_621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 1)
            return tasks.length;
        // 统计不同任务的数量
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        // 最高频task的数量
        int maxCnt = 1;
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] == cnt[25])
                maxCnt++;
        }
        return Math.max((cnt[25] - 1) * (n + 1) + maxCnt, tasks.length);
    }
}
