import java.util.HashMap;

/**
 * 面试题19. 正则表达式匹配
 */

public class Solution_19 {
    // 备忘录
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    // 动态规划匹配
    boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        if (j == n) {
            // 模式串到达末尾，则字符串应该也在末尾
            return i == m;
        }
        if (i == m) {
            // 字符串到达末尾，则模式串到达末尾或后续可以匹配空(a*b*c*...)，长度必为偶数
            if ((n - j) % 2 == 1) {
                return false;
            }
            while (j < n - 1) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
                j += 2;
            }
            return true;
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res;

        // 正常匹配，分情况讨论
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 两个字符匹配的情况，则要看p下一个字符是不是*
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2)   // *匹配0次
                        || dp(s, i + 1, p, j);  // *匹配多次
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 两字符不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);  // *匹配0次， e.g. s=ab, p=c*ab
            } else {
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
