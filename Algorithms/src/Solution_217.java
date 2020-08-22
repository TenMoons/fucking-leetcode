import java.util.Arrays;
import java.util.HashMap;

/**
 * 217.重复元素
 */

public class Solution_217 {
    // 排序
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }

    // 哈希表
    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1)
                return true;
        }
        return false;
    }
}
