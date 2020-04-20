package Algorithms;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g.length == 0 || s.length == 0)
            return 0;
        // 将胃口和饼干尺寸排序
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            // 找s[j]能满足的第一个人
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            // 找不到能满足的
            if (j >= s.length)
                return 0;
            // 找到了
            if (g[i] <= s[j]) {
                i++;
                j++;
                res++;
            }
        }
        return res;
    }
}
