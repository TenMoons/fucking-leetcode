package interview.interview7;

/**
 * 赎金信
 */

public class Solution_2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[26];
        // 统计字母频率
        for (char c : magazine.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (frequency[c - 'a'] == 0) {
                return false;
            }
            frequency[c - 'a']--;
        }
        return true;
    }
}
