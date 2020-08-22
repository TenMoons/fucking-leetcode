/**
 * 912. 排序数组
 */

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        if(nums.length == 1)
            return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right){
            swap(nums, left + (int)(Math.random() * (right - left + 1)), right);
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] -1);
            quickSort(nums, p[1] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while(left < more){
            if(nums[left] < nums[right])
                swap(nums, ++less, left++);
            else if(nums[left] > nums[right])
                swap(nums, --more, left);
            else
                left++;
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
