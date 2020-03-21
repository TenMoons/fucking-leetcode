package LeetCode;

/**
 * 无重复字符的最长子串
 */

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0, right = 0;  // 双指针初始化
        int res = 0;
        char[] arr = s.toCharArray();

        // 滑动窗口
        while (right < s.length()){
            char c1 = arr[right];
            window[c1]++;  // 出现次数+1
            right++;
            while (window[c1] > 1){  // 当前窗口出现重复字符，缩小窗口
                char c2 = arr[left];
                window[c2]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
