package LCOF;

/**
 * 面试题 58 - II. 左旋转字符串
 */

public class Solution_58_2 {
    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, arr.length - 1 - n);
        reverse(arr, arr.length - n, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char temp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = temp;
        }
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
