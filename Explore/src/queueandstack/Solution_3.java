package queueandstack;

import java.util.ArrayList;
import java.util.List;

/**
 * 打开转盘锁
 */

public class Solution_3 {
    public int openLock(String[] deadends, String target) {
        ArrayList<String> deadList = new ArrayList<>();
        for (String deadend : deadends)
            deadList.add(deadend);
        // 含有初始状态
        if (deadList.contains("0000"))
            return -1;
        // 目标就是初始状态
        if (target.equals("0000"))
            return 0;
        List<String> options = new ArrayList<>(); // 存放target改变1位数字可达的8个状态
        for (int i = 0; i < 4; i++) {
            // 处理第i位
            char[] targetArr = target.toCharArray();
            char c = targetArr[i];
            targetArr[i] = (char) ((c - 48 + 1) % 10 + 48);  // 向前转1位
            options.add(new String(targetArr));
            targetArr[i] = (char) ((c - 48 + 9) % 10 + 48);  // 向后转1位
            options.add(new String(targetArr));
        }
        options.removeAll(deadList);  // 删去死亡状态
        // target不可达
        if (options.isEmpty())
            return -1;
        int res = Integer.MAX_VALUE;
        // 从0000开始计算到达options中每一个的距离，取最小值
        for (String option : options) {
            int cnt = 1;
            char[] opt = option.toCharArray();
            for (int i = 0; i < 4; i++) {
                int step = opt[i] - 48;  // 第i位距离0的距离
                if (step > 5)   // 如果>5，则向后转距离更短
                    step = 10 - step;
                cnt += step;
            }
            res = Math.min(res, cnt);
        }
        return res;
    }
}
