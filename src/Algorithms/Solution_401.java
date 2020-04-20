package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 */

public class Solution_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] led = new int[] {
                8, 4, 2, 1,  // 小时
                32, 16, 8, 4, 2, 1  // 分钟
        };
        backtrack(num, led, 0, 0, res, 0);
        return res;
    }

    private void backtrack(int num, int[] led, int hour, int minute, List<String> res, int start) {
        if (num == 0) {
            if (hour > 11 || minute > 59)
                return;
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            // 分钟必须是两位数
            if (minute < 10)
                sb.append(0);
            sb.append(minute);
            res.add(new String(sb));
            return;
        }
        for (int i = start; i < led.length; i++) {
            // 做选择
            if (i < 4)
                hour += led[i];
            else
                minute += led[i];
            // 回溯
            backtrack(num - 1, led, hour, minute, res, i + 1);
            // 撤销选择
            if (i < 4)
                hour -= led[i];
            else
                minute -= led[i];
        }
    }
}
