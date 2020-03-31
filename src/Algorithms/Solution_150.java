package Algorithms;

import java.util.Stack;

/**
 * 150.逆波兰表达式求值
 */

public class Solution_150 {
    // 栈
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int opnd1, opnd2;
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    opnd2 = stack.pop();
                    opnd1 = stack.pop();
                    stack.push(opnd1 + opnd2);
                    break;
                case "-" :
                    opnd2 = stack.pop();
                    opnd1 = stack.pop();
                    stack.push(opnd1 - opnd2);
                    break;
                case "*" :
                    opnd2 = stack.pop();
                    opnd1 = stack.pop();
                    stack.push(opnd1 * opnd2);
                    break;
                case "/" :
                    opnd2 = stack.pop();
                    opnd1 = stack.pop();
                    stack.push(opnd1 / opnd2);
                    break;
                default :
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    // 数组模拟
    public int evalRPN2(String[] tokens) {
        int[] arr = new int[tokens.length / 2 + 1];
        int idx = 0;  // 当前可以放入数的下标
        for (String token : tokens) {
            switch (token) {
                case "+":
                    arr[idx - 2] += arr[--idx];
                    break;
                case "-":
                    arr[idx - 2] -= arr[--idx];
                    break;
                case "*":
                    arr[idx - 2] *= arr[--idx];
                    break;
                case "/":
                    arr[idx - 2] /= arr[--idx];
                    break;
                default:
                    arr[idx++] = Integer.parseInt(token);
                    break;
            }
        }
        return arr[0];
    }
}
