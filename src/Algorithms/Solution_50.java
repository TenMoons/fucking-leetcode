package Algorithms;

/**
 * #LeetCode 50 Pow(x, n)
 */

public class Solution_50 {
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        long temp = n;
        temp = temp > 0 ? temp : -temp;
        double ans = 1;
        double base = x;
        while(temp > 0){
            if((temp & 1) == 1){
                ans = ans * base;
            }
            base = base * base;
            temp >>= 1;
        }
        if(n > 0){
            return ans;
        }else{
            return 1/ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.25, -2));
        System.out.println(myPow(2.5, 10));
        System.out.println(myPow(2, -2147483648));
    }
}
