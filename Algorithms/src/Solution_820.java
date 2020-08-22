import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 */

public class Solution_820 {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        // 反转字符串
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        // 排序
        Arrays.sort(words);
        // 比较相邻字符串是否是相同前缀（原字符串有相同后缀），则可以合并
        for (int i = 0; i < words.length - 1; i++) {
            int len = words[i].length();
            if (words[i].length() <= words[i + 1].length() && words[i].equals(words[i + 1].substring(0, len)))
                continue;
            res += len + 1;  // 加上#的长度1
        }
        return res + words[words.length - 1].length() + 1;
    }
}
