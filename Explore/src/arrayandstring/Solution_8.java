package arrayandstring;

/**
 * 实现strStr()
 */

public class Solution_8 {
    // KMP算法
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (haystack.equals(""))
            return -1;
        // 初始化
        int[] next = new int[needle.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < needle.length()) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            next[i] = j;
        }
        // KMP
        i = j = 0;
        while (i < haystack.length()) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j))  // 当前指针所指的两个字符不相等
                j = next[j];
            i++;
            j++;
            if (j == needle.length())
                return i - j;  // 子串起始下标
        }
        return -1;
    }
}
