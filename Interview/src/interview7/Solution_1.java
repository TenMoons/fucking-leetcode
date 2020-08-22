package interview7;

import java.util.HashSet;

/**
 * 国际摩斯密码
 */

public class Solution_1 {
    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        String[] morse = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
