package bytedance.string;

/**
 * 字符串的排列
 */

public class Solution_3 {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }
        int sum = 0;
        for (int v : target) {
            if (v != 0) {
                sum++;
            }
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            int temp = s2.charAt(right) - 'a';
            window[temp]++;
            right++;
            // 当前是目标字符
            if (target[temp] != 0) {
                if (target[temp] == window[temp]) {
                    valid++;
                }
            }
            while (right - left == s1.length()) {
                if (valid == sum) {
                    return true;
                }
                int tmp = s2.charAt(left) - 'a';
                left++;
                if (target[tmp] == window[tmp]) {
                    valid--;
                }
                window[tmp]--;
            }
        }
        return false;
    }
}
