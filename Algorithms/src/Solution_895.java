import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 895. 最大频率栈
 */

public class Solution_895 {
    class FreqStack {
        // 频率对应的元素，按时序排列
        HashMap<Integer, ArrayDeque<Integer>> freqToVal = new HashMap<>();
        // 元素对应的频率
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        // 最大频率
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int x) {
            // 当前元素的频率
            int curFreq = valToFreq.getOrDefault(x, 0) + 1;
            valToFreq.put(x, curFreq);
            // 频率到元素的映射
            freqToVal.putIfAbsent(curFreq, new ArrayDeque<>());
            freqToVal.get(curFreq).push(x);
            maxFreq = Math.max(maxFreq, curFreq);
        }

        public int pop() {
            ArrayDeque<Integer> maxFreqVals = freqToVal.get(maxFreq);
            int res = maxFreqVals.poll();
            int freq = valToFreq.get(res) - 1;
            valToFreq.put(res, freq);
            if (maxFreqVals.isEmpty()) {
                // 最大频率的元素只有1个
                maxFreq--;
            }
            return res;
        }
    }

}
