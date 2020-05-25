package LCOF;

/**
 * 面试题 50. 第一个只出现一次的字符
 */

public class Solution_50 {
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        char[] arr = s.toCharArray();
        int[] cnt = new int[128];
        for (char c : arr) {
            cnt[c]++;
        }
        for (char c : arr) {
            if (cnt[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
