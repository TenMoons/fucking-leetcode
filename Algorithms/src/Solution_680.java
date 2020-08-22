/**
 * 680. 验证回文字符串 Ⅱ
 */

public class Solution_680 {
    public boolean validPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int lo = 0, hi = s.length() - 1;
        boolean res = true;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return isPalindrome(s, lo + 1, hi) || isPalindrome(s, lo, hi - 1);
            }
            lo++;
            hi--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int lo, int hi) {
        while (lo != hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi++;
        }
        return true;
    }
}
