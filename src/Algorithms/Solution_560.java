package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */

public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // subSum[i..j] = subSum[0..j] - subSum[0..i - 1]
        int[] preSum = new int[nums.length + 1];  // 前缀和
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // 哈希表+前缀和优化
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        // <前缀和的值，前缀和为该值的个数>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // subSum[i..j] = subSum[0..j] - subSum[0..i - 1]
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            // 前缀和为preSum - k的个数
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            // 维护map
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
