package com.leetcode.dynamic.d06;

import java.util.Arrays;

/**
 * @author Kar
 * @create 2021-11-30 下午4:50
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray subarray = new MaximumProductSubarray();
        System.out.println(subarray.maxProduct(new int[]{-2}));
        System.out.println(subarray.maxProduct(new int[]{-2, 3, -4}));
    }

    // 维护一个以当前元素结尾的最大/小乘积子数组
    public int maxProduct(int[] nums) {
        int l = nums.length;
        int[] maxF = Arrays.copyOfRange(nums, 0, l);
        int[] minF = Arrays.copyOfRange(nums, 0, l);
        for (int i = 1; i < l; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(minF[i-1]*nums[i],Math.min(maxF[i - 1] * nums[i], nums[i]));
        }
        int max = nums[0];
        for (int i = 0; i < l; i++) {
            max = Math.max(max, maxF[i]);
        }
        return max;
    }
}
