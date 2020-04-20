package Algorithms;

/**
 * 12. 整数转罗马数字
 */

public class Solution_12 {
    public String intToRoman(int num) {
        String[] roman = new String[] {
                "M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] ints = new int[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < roman.length; i++) {
            while (num >= ints[i]) {
                sb.append(roman[i]);
                num -= ints[i];
            }
        }
        return sb.toString();
    }
}
