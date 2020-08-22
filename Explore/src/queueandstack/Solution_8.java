package queueandstack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */

public class Solution_8 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int op1, op2;
        for (String token : tokens) {
            if (token.equals("+")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 + op2);
            } else if (token.equals("-")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 - op2);
            } else if (token.equals("*")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 * op2);
            } else if (token.equals("/")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 / op2);
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }

    // 数组模拟
    public int evalRPN2(String[] tokens) {
        int[] op = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    op[index - 2] += op[--index];
                    break;
                case "-":
                    op[index - 2] -= op[--index];
                    break;
                case "*":
                    op[index - 2] *= op[--index];
                    break;
                case "/":
                    op[index - 2] /= op[--index];
                    break;
                default:
                    op[index++] = Integer.parseInt(token);
            }
        }
        return op[0];
    }
}
