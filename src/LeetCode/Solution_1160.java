package LeetCode;

/**
 * 1160.拼写单词
 */

public class Solution_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] table = new int[26];  // 存放chars每个字母出现的次数
        for (int i = 0; i < chars.length(); i++){
            table[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        count : for (String word : words){
            // 对每个单词统计字母出现频数，再和table比较
            int[] wordTable = new int[26];
            for (int i = 0; i < word.length(); i++){
                wordTable[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++){
                if (wordTable[i] > table[i])  // 超过chars提供的字母数量
                    continue count;
            }
            res += word.length();
        }
        return res;
    }
}
