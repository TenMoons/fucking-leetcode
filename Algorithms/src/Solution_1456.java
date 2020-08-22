import java.util.HashMap;
import java.util.Map;

/**
 * 1456. 定长子串中元音的最大数目
 */

public class Solution_1456 {
    public int maxVowels(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        int left = 0, right = 0, valid = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (map.containsKey(c)) {
                valid++;
            }
            while (right - left >= k) {
                res = Math.max(res, valid);
                char d = s.charAt(left);
                left++;
                if (map.containsKey(d)) {
                    valid--;
                }
            }
        }
        return res;
    }
}
