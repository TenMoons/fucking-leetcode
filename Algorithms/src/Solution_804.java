import java.util.HashSet;
import java.util.Set;

/**
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-").
 * We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 *
 */

public class Solution_804 {
    private final String[] code = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
            "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>(words.length / 2);
        for (String word : words){
            StringBuilder temp = new StringBuilder();
            for (char c: word.toCharArray()){
                temp.append(code[c - 97]);
            }
            res.add(temp.toString());
        }
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_804().uniqueMorseRepresentations(new String[]{
                "gin", "zen", "gig", "msg"
        }));
    }
}
