import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 */

public class Solution_567 {
    // s2中是否有包含s1的排列转换为：
    // 滑动窗口问题 => s2中是否有子串与s1等长，且字符出现次数一致
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            // 扩大窗口
            char c = s2.charAt(right);
            right++;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 满足条件的字符数+1
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }
            // 缩小窗口
            while (right - left >= s1.length()) {
                // 找到了排列
                if (valid == target.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (target.containsKey(d)) {
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    // 用数组对哈希表进行优化
    public boolean checkInclusion2(String s1, String s2) {
        // 仅出现小写字母
        int[] target = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }
        int len = 0;
        for (int v : target) {
            if (v != 0) {
                len++;
            }
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            int temp = c - 'a';
            if (target[temp] != 0) {
                window[temp]++;
                if (window[temp] == target[temp]) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == len) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                int tmp = d - 'a';
                if (target[tmp] != 0) {
                    if (target[tmp] == window[tmp]) {
                        valid--;
                    }
                    window[tmp]--;
                }
            }
        }
        return false;
    }
}
