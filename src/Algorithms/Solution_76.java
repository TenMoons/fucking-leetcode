package Algorithms;

/**
 * 76.最小覆盖子串
 */

public class Solution_76 {
    // 数组代替HashMap提高性能
    public String minWindow(String s, String t) {
        // 初始化
        int[] target = new int[128];  // 统计t中每个字符出现次数
        int[] window = new int[128];  // 统计滑动窗口中每个字符出现次数
        for (char ch : t.toCharArray())   // 统计t中每个字符出现次数
            target[ch]++;
        int left = 0, right = 0;
        int t_Len = t.length();
        int count = 0;   // 候选字符数
        int minLen = s.length() + 1;
        String res = "";

        // 滑动窗口
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;   // 统计当前窗口中每个字符出现次数
            right++;
            // 当这个字符是在t中，并且t需要的次数大于等于该字符在滑动窗口出现的次数，被确定为候选字符
            if (target[ch] > 0 && target[ch]  >= window[ch])
                count++;
            //当前窗口已包含子串，开始缩小窗口，更新结果
            while (count == t_Len){
                ch = s.charAt(left);
                if (target[ch] > 0 && target[ch]  >= window[ch]){
                    count--;
                }
                // 更新结果
                if ((right - left)< minLen){
                    minLen = (right - left) + 1;  // 当前窗口大小
                    res = s.substring(left, right);
                }
                window[ch]--;
                left++;
            }
        }
        return res;
    }
}
