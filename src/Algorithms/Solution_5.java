package Algorithms;

/**
 * 5. 最长回文子串
 */

public class Solution_5 {
    public String longestPalindrome(String s) {
        String res = "";
        // 以字符为中心，向两边扫描判断回文串
        for (int i = 0; i < s.length(); i++) {
            String palindrome1 = longestPalindrome(s, i, i);  // 长度为奇数的情况
            String palindrome2 = longestPalindrome(s, i, i + 1);  // 长度为偶数的情况
            res = res.length() > palindrome1.length() ? res : palindrome1;
            res = res.length() > palindrome2.length() ? res : palindrome2;
        }
        return res;
    }

    // 双指针
    private String longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);  // 返回当前找到的回文子串
    }
}
