package Algorithms;

public class Solution_9 {
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else if (x == 0)
            return true;
        int temp = x;
        int val = 0;
        while (x != 0){
            val = val * 10 + x % 10;
            x /= 10;
        }
        return val == temp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
