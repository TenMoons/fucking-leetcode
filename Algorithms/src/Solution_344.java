/**
 * 344. 反转字符串
 */

public class Solution_344 {
    public void reverseString(char[] s) {
        int lo = 0, hi = s.length - 1;
        while (lo < hi) {
            char temp = s[lo];
            s[lo++] = s[hi];
            s[hi--] = temp;
        }
    }
}
