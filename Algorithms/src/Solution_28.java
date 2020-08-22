/**
 * 28.实现strStr()
 */

public class Solution_28 {
    // 滑动窗口：用needle.length()作为窗口size
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        if(haystack.equals(""))
            return -1;
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle))  // 右边界是i + needleLen，因为左闭右开
                return i;
        }
        return -1;
    }

    // KMP算法
    public int strStr2(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        if(haystack.equals(""))
            return -1;

        // 构造next数组
        int j = -1, i = 0;
        int[] next = new int[needle.length() + 1];
        next[0] = -1;
        while (i < needle.length()) {
            while (j >= 0 && needle.charAt(j) != needle.charAt(i))
                j = next[j];
            i++;
            j++;
            next[i] = j;
        }

        // 开始匹配
        i = j = 0;  // i是haystack的指针，j是needle的指针
        while (i < haystack.length()) {
            // 有字符不匹配，则查找next数组获取跳转下标
            while (j >= 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j];
            i++;
            j++;
            if (j == needle.length())  // 匹配成功
                return i - j;
        }
        return -1;
    }
}
