package arrayandstring;

import java.util.Arrays;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */

public class Solution_9 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0)
            return "";
        if (len == 1)
            return strs[0];
        // 按字典序排序
        Arrays.sort(strs);
        // 排序后的第一个字符串和最后一个字符串的最长公共前缀就是所求
        for (int i = 0; i < strs[0].length() && i < strs[len - 1].length(); i++) {
            if (strs[0].charAt(i) != strs[len - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
