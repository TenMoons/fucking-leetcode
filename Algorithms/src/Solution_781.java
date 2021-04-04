import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 781. 森林中的兔子
 */

public class Solution_781 {
    // 解法1：纯数学解法
    // 先记录每个数出现的次数，然后分析：
    // 如果数x出现了y次，那么：
    // 1. y % (x + 1) == 0 => 至少有y只 (即：y / (x + 1) * (x + 1)只)
    // 2. y % (x + 1) != 0 => 至少有(y / (x + 1) + 1) * (x + 1)只
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        int res = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer val = map.get(key);
            if (val % (key + 1) == 0) {
                res += val;
            } else {
                res += (val / (key + 1) + 1) * (key + 1);
            }
        }
        return res;
    }

    // 非数学解法，从以下3点考虑：
    // 所有报数不同的，一定是不同颜色的
    // 如果有1只兔子报了x，那么至少有x+1只兔子
    // 如果有1只兔子报了x，那么从最少情况出发，可以最多忽略后面同样报x的x只兔子
    public int numRabbits2(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int answer : answers) {
            if (answer == 0) {
                res++;
            } else if (!map.containsKey(answer) || map.get(answer) == 0) {
                // 前面没出现过answer，或者已经消耗完answer个answer
                map.put(answer, answer);
                res += answer + 1;
            } else {
                map.put(answer, map.get(answer) - 1);
            }
        }

        return res;
    }
}
