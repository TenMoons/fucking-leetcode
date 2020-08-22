package bytedance.string;

import java.util.Arrays;

/**
 * 最长公共前缀
 */

public class Solution_2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String lo = strs[0], hi = strs[strs.length - 1];  // 最短和最长字符串
        for (int i = 0; i < lo.length(); i++) {
            if (lo.charAt(i) != hi.charAt(i)) {
                return lo.substring(0, i);
            }
        }
        return lo;
    }
}
