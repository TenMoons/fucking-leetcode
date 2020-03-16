package LeetCode;

/**
 * 面试题 01.06. 字符串压缩
 */

public class Solution_0106 {
    public String compressString(String S) {
        if (S == null || S.length() <= 1)
            return S;
        int len = S.length();
        int slow = 0, fast = 1;  // slow记录相同字符的起始位置，fast记录终止位置,fast - slow表示个数
        StringBuilder sb = new StringBuilder();
        while (fast < len){
            if (S.charAt(slow) != S.charAt(fast)){
                sb.append(S.charAt(slow));
                sb.append(fast - slow);
                slow = fast++;
            } else {
                fast++;
            }
        }
        // 处理最后一个
        sb.append(S.charAt(slow));
        sb.append(fast - slow);

        String res = sb.toString();
        return res.length() < S.length() ? res : S;
    }
}
