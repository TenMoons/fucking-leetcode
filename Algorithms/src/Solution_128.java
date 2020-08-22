import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 */

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int cur = num;
                int curLen = 1;
                // 向左搜索
                while (set.remove(--cur));
                curLen += (num - cur - 1);
                // 向右搜索
                cur = num;
                while (set.remove(++cur));
                curLen += (cur - num - 1);
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
