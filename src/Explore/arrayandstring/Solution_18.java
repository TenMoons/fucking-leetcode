package Explore.arrayandstring;

import java.util.Arrays;
import java.util.Collections;

/**
 * 翻转字符串里的单词
 */

public class Solution_18 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        // 先翻转整个数组
        int len = arr.length;
        reverse(arr, 0, len - 1);
        // 翻转每一个单词
        int left = 0, right = 0;
        // 滑动窗口
        while (right < len) {
            // 找单词的开头
            while (left < len && arr[left] == ' ')
                left++;
            right = left;
            // 找单词的末尾
            while (right < len && arr[right] != ' ')
                right++;
            // 单词范围为arr[left...right - 1]
            reverse(arr, left, right - 1);
            left = right;
        }
        // 清除多余的空格
        left = right = 0;
        while (right < len) {
            // 单词前的空格
            while (right < len && arr[right] == ' ')
                right++;
            // 遇到单词
            while (right < len && arr[right] != ' ')
                arr[left++] = arr[right++];  // 相当于单词向前移动，覆盖空格
            // 单词之后的空格
            while (right < len && arr[right] == ' ')
                right++;
            if (right < len)
                arr[left++] = ' ';
        }
        return new String(arr).substring(0, left);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public String reverseWords3(String s) {
        s = s.trim();
        String[] words = s.split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);  // 去掉最后一个空格
    }
}
