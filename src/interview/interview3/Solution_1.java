package interview.interview3;

import java.util.TreeMap;

public class Solution_1 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length == 1)
            return true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 统计频次
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first;i < first + k;i++) {
                if (!map.containsKey(i))
                    return false;
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}
