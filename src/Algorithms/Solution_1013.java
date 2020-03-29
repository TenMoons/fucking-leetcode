package Algorithms;

/*
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
形式上，如果可以找出索引 i+1 < j 
且满足 (A[0] + A[1] + ... + A[i]
== A[i+1] + A[i+2] + ... + A[j-1]
== A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 */

public class Solution_1013 {
    // 双指针
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int item : A)
            sum += item;
        // 满足条件则sum一定是3的倍数
        if (sum % 3 != 0)
            return false;
        int left = 0, right = A.length - 1;
        int leftSum = A[left], rightSum = A[right];
        while(left < right - 1){  // 中间部分至少要有1个元素
            if (leftSum == sum / 3 && rightSum == sum / 3)
                return true;
            if (leftSum != sum / 3){
                leftSum += A[++left];
            }
            if (rightSum != sum / 3){
                rightSum += A[--right];
            }
        }
        return false;
    }
}
