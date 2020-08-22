package interview8;

/**
 * 猜数字
 */

public class Solution_0 {
    public String getHint(String secret, String guess) {
        int[] secretCnt = new int[10];
        int[] guessCnt = new int[10];
        char[] secrets = secret.toCharArray();
        char[] guesss = guess.toCharArray();
        for (char c : secrets) {
            secretCnt[c - '0']++;
        }
        for (char c : guesss) {
            guessCnt[c - '0']++;
        }
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c1 = secrets[i], c2 = guesss[i];
            if (c1 == c2) {
                bulls++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (secretCnt[i] != 0 && guessCnt[i] != 0) {
                cows += Math.min(secretCnt[i], guessCnt[i]);
            }
        }
        return bulls + "A" + (cows - bulls) + "B";
    }
}
