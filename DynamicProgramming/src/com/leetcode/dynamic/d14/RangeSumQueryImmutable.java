package com.leetcode.dynamic.d14;

/**
 * @author Kar
 * @create 2021-12-09 下午3:03
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(numArray.sumRange(1, 4));
    }
}
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = nums[i] + sum[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}