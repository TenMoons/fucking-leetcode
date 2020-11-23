/**
 * 面试题48. 最长不含重复字符的子字符串
 */

public class Solution_48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int[] cnt = new int[128];  // 统计出现频率 128?
        char[] arr = s.toCharArray();
        int res = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            cnt[arr[right]]++;
            while (cnt[arr[right]] > 1) {  // 重复
                cnt[arr[left]]--;
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}
