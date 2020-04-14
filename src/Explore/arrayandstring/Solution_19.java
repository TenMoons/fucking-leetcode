package Explore.arrayandstring;

/**
 * 反转字符串中的单词 III
 */

public class Solution_19 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            reverse(arr, 0, arr.length - 1);  // 翻转单个单词
            sb.append(arr).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String reverseWords2(String s) {
        int left = 0, right = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        while (right < len) {
            while (right < len && arr[right] != ' ')
                right++;
            reverse(arr, left, right - 1);  // 翻转单词
            left = right + 1;
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
