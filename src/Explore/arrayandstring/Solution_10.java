package Explore.arrayandstring;

/**
 * 反转字符串
 */

public class Solution_10 {
    public void reverseString(char[] s) {
        if (s.length == 0)
            return;
        if (s.length == 1)
            return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
