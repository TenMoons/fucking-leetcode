package LeetCode;

import java.util.HashMap;

/**
 * 罗马数字转整数
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 */

public class Solution_13 {
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] keys = new char[]{
                'I', 'V', 'X', 'L', 'C', 'D', 'M'
        };
        int[] values = new int[]{
                1, 5, 10, 50, 100, 500, 1000
        };
        int res = 0;
        for (int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }
        for (int i = 0; i < s.length(); i++){
            int thisVal = 0;
            if(i != s.length() - 1){
                if (s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                    thisVal = 4;
                    i++;
                }else if (s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
                    thisVal = 9;
                    i++;
                }else if (s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
                    thisVal = 40;
                    i++;
                }else if (s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
                    thisVal = 90;
                    i++;
                }else if (s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                    thisVal = 400;
                    i++;
                }else if (s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
                    thisVal = 900;
                    i++;
                }else {
                    thisVal = map.get(s.charAt(i));
                }
            }else {
                thisVal = map.get(s.charAt(i));
            }
            res += thisVal;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("IXLVIII"));
    }
}
