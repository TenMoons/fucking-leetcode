package LeetCode;

import java.util.Scanner;

/**
 * 202. Happy Number
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, 正数开头
 * replace the number by the sum of the squares of its digits,用每位数的平方之和代替该数
 * and repeat the process until the number equals 1 (where it will stay), 直到该数变成1
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 */

public class Solution_202 {
    public static void main(String[] args) {
        // 获取数据
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        boolean flag = judgeHappyNumber(num);
        System.out.println(flag);
    }

    public static boolean judgeHappyNumber(int val){
        Integer n = new Integer(val);
        String num = n.toString();
        if(num.charAt(0) <= '0' || num.charAt(0) > '9')
            return false;
        Integer sumOfDigits = 0;
        int cnt = 0;
        while(cnt++ <= 1e4){
            sumOfDigits = 0;
            if(num.equals("1"))
                return true;
            for (int i = 0; i < num.length(); i++) {
                sumOfDigits += (int)(num.charAt(i) - '0') * (int)(num.charAt(i) - '0');
            }
            num = sumOfDigits.toString();
        }
        if (sumOfDigits == 1)
            return true;
        else
            return false;
    }
}
