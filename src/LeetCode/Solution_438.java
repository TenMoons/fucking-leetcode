package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 */

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 初始化
        int[] target = new int[128];  // 统计t中每个字符出现次数
        int[] window = new int[128];  // 统计滑动窗口中每个字符出现次数
        for (char ch : p.toCharArray())   // 统计t中每个字符出现次数
            target[ch]++;
        int left = 0, right = 0;
        int t_Len = p.length();
        int count = 0;   // 候选字符数

        // 滑动窗口
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;   // 统计当前窗口中每个字符出现次数
            // 当这个字符是在t中，并且t需要的次数大于等于该字符在滑动窗口出现的次数，被确定为候选字符
            if (target[ch] > 0 && target[ch]  >= window[ch])
                count++;
            //当前窗口已包含子串，开始缩小窗口，更新结果
            while (count == t_Len){
                // 确定窗口
                ch = s.charAt(left);
                if (target[ch] > 0 && target[ch]  >= window[ch]){
                    count--;
                }
                // 更新结果
                if ((right - left) + 1 == t_Len){
                    res.add(left);  // 当前子串的起始索引加入列表
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
