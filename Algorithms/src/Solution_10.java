import java.util.HashMap;

/**
 * 10. 正则表达式匹配
 */

public class Solution_10 {
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    // 判断s[i...]与p[j...]是否能够匹配
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        // base case-1: 模式串p到达串尾，则s必须也到达串尾
        if (j == n) {
            return i == m;
        }
        // base case-2: 模式串s到达串尾，则有两种情况
        // 1. p也到达串尾
        // 2. p余下的部分可以匹配空串
        if (i == m) {
            // 如果可以匹配空串，则必须是a*b*c*模式，即剩余长度必须为偶数
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
        String curKey = i + "," + j;
        if (memo.containsKey(curKey)) {
            return memo.get(curKey);
        }
        boolean res = false;

        // 两字符匹配
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res =  dp(s, i, p, j + 2) || // *匹配0次
                        dp(s, i + 1, p, j);  // *匹配多次
            } else {
                res = dp(s, i + 1, p, j + 1);  // 常规匹配
            }
        } else {
            // 两字符不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);  // *匹配0次， e.g. s=ab, p=c*ab
            } else {
                res = false;
            }
        }
        memo.put(curKey, res);
        return res;
    }
}
