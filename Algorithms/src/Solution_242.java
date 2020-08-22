import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 */

public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}
