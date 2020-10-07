/**
 * 557. 反转字符串中的单词 III
 */

public class Solution_557 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String cur : arr) {
            sb.append(reverse(cur)).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String reverse(String s) {
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        while(lo < hi) {
            char temp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = temp;
        }
        return new String(arr);
    }
}
