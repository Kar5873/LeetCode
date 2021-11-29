package com.leetcode.dynamic.d05;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author kar
 * @create 2021-11-29 23:51
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum = Math.max(sum+num,num);
            max = Math.max(sum,max);
        }
        return max;
    }
}
