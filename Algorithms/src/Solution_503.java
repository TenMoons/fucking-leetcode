import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 */

public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.poll()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return res;
    }
}
