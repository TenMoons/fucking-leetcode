package LCOF;

/**
 * 面试题05. 替换空格
 */

public class Solution_5 {
    public String replaceSpace(String s) {
        if (s.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        String rep = "%20";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append(rep);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
