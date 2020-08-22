import java.util.Arrays;
import java.util.HashMap;

/**
 * 169.多数元素
 * 给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class Solution_169 {
    // 直观思路：HashMap
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num))
                map.put(num, 1);
            else{
                int times = map.get(num) + 1;
                map.put(num, map.get(num) + 1);
                if (times > nums.length / 2){
                    return num;
                }
            }
        }
        return 0;
    }

    // 排序后取数组中间元素
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 摩尔投票法
    public int majorityElement3(int[] nums){
        int candidate = nums[0];  // 候选人
        int cnt = 1;  // 候选人票数
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == candidate)
                cnt++;
            else {
                cnt--;
                if (cnt == 0){
                    candidate = nums[i];  // 更换候选人
                    cnt = 1;  // 清除票数
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_169().majorityElement3(new int[]{
                6, 5, 5
        }));
    }
}
