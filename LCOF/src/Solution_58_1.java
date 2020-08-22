/**
 * 面试题 58 - I. 翻转单词顺序
 */

public class Solution_58_1 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        int lo = 0, hi = words.length - 1;
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) {
                continue;
            }
            res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    }
}
