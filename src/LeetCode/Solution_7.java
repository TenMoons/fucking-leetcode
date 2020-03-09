package LeetCode;

public class Solution_7 {
    public static int reverse(int x) {
        try{
            Integer value = new Integer(x);
            StringBuilder result = new StringBuilder();
            String num;
            if (x < 0){
                result.append('-');
                num = new StringBuilder(value.toString().substring(1)).reverse().toString();
            }
            else{
                num = new StringBuilder(value.toString()).reverse().toString();
            }
            result.append(num);
            return Integer.parseInt(result.toString());
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        int num = reverse(-1234599999);
        System.out.println(num);
    }
}
