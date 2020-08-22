import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.18. 最短超串
 */

public class Solution_1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        int[] res = new int[2];
        Map<Integer, Integer> target = new HashMap<>();
        Map<Integer, Integer> window = new HashMap<>();
        for (int v : small) {
            target.put(v, target.getOrDefault(v, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int len = Integer.MAX_VALUE;
        while (right < big.length) {
            int num = big[right];
            right++;
            if (target.containsKey(num)) {
                window.put(num, window.getOrDefault(num, 0) + 1);
                if (target.get(num).equals(window.get(num))) {
                    valid++;
                }
            }
            while (valid >= small.length) {
                if (right - left < len) {
                    len = right - left;
                    res[0] = left;
                    res[1] = right - 1;
                }
                int tmp = big[left];
                left++;
                if (target.containsKey(tmp)) {
                    if (target.get(tmp).equals(window.get(tmp))) {
                        valid--;
                    }
                    window.put(tmp, window.get(tmp) - 1);
                }
            }
        }
        return res[1] == 0 ? new int[]{} : res;
    }
}
