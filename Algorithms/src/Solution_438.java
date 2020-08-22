import java.util.ArrayList;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 */

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] target = new int[26];
        int[] window = new int[26];
        int len = 0;
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        for (int v : target) {
            if (v != 0) {
                len++;
            }
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            // 扩大窗口
            char c = s.charAt(right);
            right++;
            int temp = c - 'a';
            // c是目标字符
            if (target[temp] != 0) {
                window[temp]++;
                if (window[temp] == target[temp]) {
                    valid++;
                }
            }
            // 收缩窗口
            while (right - left >= p.length()) {
                if (valid == len) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                int tmp = d - 'a';
                if (target[tmp] != 0) {
                    // 窗口中目标字符减少
                    if (window[tmp] == target[tmp]) {
                        valid--;
                    }
                    window[tmp]--;
                }
            }
        }
        return res;
    }
}
