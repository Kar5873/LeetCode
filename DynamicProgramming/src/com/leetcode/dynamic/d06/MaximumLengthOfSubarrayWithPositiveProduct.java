package com.leetcode.dynamic.d06;

import java.util.Arrays;

/**
 * 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 *
 * @author Kar
 * @create 2021-11-30 下午5:32
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {
        int l = nums.length;
        // 记录乘积为正数的子数组长度
        int positive = nums[0] > 0 ? 1 : 0;
        // 记录乘积为负数的子数组长度
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < l; i++) {
            // 遇到元素为正数，不会改变乘积的正负性
            if (nums[i] > 0) {
                // 增加乘积为正数的子数组长度
                positive++;
                // 增加乘积为负数的子数组，或依旧为0
                negative = negative > 0 ? negative + 1 : 0;
            // 遇到元素为负数，会改变乘积的正负性
            } else if (nums[i] < 0) {
                // 乘积为正数的子数组长度 会变成 乘积为负数的子数组长度 加1，或者为0
                int newPositive = negative > 0 ? negative + 1 : 0;
                // 乘积为负数的子数组长度 会变成 乘积为正数的子数组长度 加1
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = negative = 0;
            }
            // 保存出现过的 乘积为正数的 最长子数组长度
            maxLength = Math.max(maxLength,positive);
        }
        return maxLength;
    }
}
