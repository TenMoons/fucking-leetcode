package Algorithms;

/**
 * 50. Pow(x, n)
 */

public class Solution_50 {
    public double myPow(double x, int n) {
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

    public double myPow2(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }

}
