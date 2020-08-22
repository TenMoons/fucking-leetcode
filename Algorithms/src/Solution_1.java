import java.util.HashMap;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> results = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            if(results.containsKey(another)){
                return new int[] {results.get(another), i};
            }
            results.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
