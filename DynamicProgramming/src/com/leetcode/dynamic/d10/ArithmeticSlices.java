package com.leetcode.dynamic.d10;

import java.util.Arrays;

/**
 * 413. 等差数列划分难度中等
 * <p>
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * <p>
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 *
 * @author kar
 * @create 2021-12-06 23:11
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(new int[]{1,2,3,5,7,9}));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        if (l <= 2) {
            return 0;
        }
        int gap = nums[1] - nums[0];
        int count = 0;
        int ans = 0;
        for (int i = 2; i < l; i++) {
            if (gap == nums[i] - nums[i - 1]) {
                count++;
            } else {
                count = 0;
                gap = nums[i] - nums[i - 1];
            }
            ans += count;
        }
        return ans;
    }

}
