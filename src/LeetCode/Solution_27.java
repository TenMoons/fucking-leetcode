package LeetCode;

public class Solution_27 {
    /*
    双指针
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j++]; // nums[j] != val，这个元素需要保留
            } else {
                j++;  // nums[j] == val，不用保留，直接忽略，往后遍历
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 2, 3};
        int res = removeElement(nums, 3);
        System.out.println("num = " + res);
        for (int item: nums) {
            System.out.print(item + " ");
        }
    }
}
