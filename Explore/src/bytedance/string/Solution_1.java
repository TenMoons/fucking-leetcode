package bytedance.string;

/**
 * 无重复的最长子串
 */

public class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] window = new int[128];
        int left = 0, right = 0, res = 1;
        while (right < s.length()) {
            int c = s.charAt(right);
            right++;
            window[c]++;
            while (window[c] > 1) {
                int d = s.charAt(left);
                left++;
                window[d]--;
            }
            res = Math.max(res, right - left - 1);
        }
        return res;
    }
}
