package LeetCode;

/**
 * 75.颜色分类
 * 模板：荷兰国旗问题
 * 关键思路：快速排序
 */

public class Solution_75 {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1, 1);
    }

    // <k的放左边，==k的放中间，>k的放右边
    private void partition(int[] arr, int left, int right, int k){
        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while(cur < more){
            if(arr[cur] < k){
                swap(arr, ++less, cur++);  // 交换arr[less + 1]和arr[cur]
            }
            else if(arr[cur] > k){
                swap(arr, --more, cur);  // 交换arr[more - 1]和arr[cur]
            }
            else{  // == k
                cur++;
            }
        }
    }

    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        new Solution_75().sortColors(
                new int[]{
                        2, 0, 2, 1, 1, 0
                }
        );
    }
}
