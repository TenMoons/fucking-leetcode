/**
 * 424. 替换后的最长重复字符
 */

public class Solution_424 {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0)
            return 0;
        int[] cnt = new int[26];
        int max = 0;
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        while (right < s.length()) {
            cnt[arr[right] - 65]++;
            max = Math.max(max, cnt[arr[right] - 65]);
            // 当可以替换的字符个数大于k时，我们需要缩小窗口
            // 窗口长度：right - left + 1
            // 可替换的字符数: right - left + 1 - max
            if (right - left + 1 > max + k) {
                cnt[arr[left] - 'A']--;
                left++;
            }
            right++;
        }
        return arr.length - left;
    }
}
