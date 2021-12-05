package com.leetcode.dynamic.d09;

/**
 * 9-2 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author kar
 * @create 2021-12-05 21:33
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
        System.out.println(water.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(water.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    // 方法一：动态规划
    public int trap(int[] height) {
        int l = height.length;
        if (l == 0) {
            return 0;
        }
        // 正向遍历数组 height 得到数组 leftMax 的每个元素值
        // leftMax 元素表示左边高点能为height数组每个坐标保留雨水的最大值
        int[] leftMax = new int[l];
        leftMax[0] = height[0];
        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 反向遍历数组 height 得到数组 rightMax 的每个元素值。
        // rightMax 元素表示右边高点能为height数组每个坐标保留雨水的最大值
        int[] rightMax = new int[l];
        rightMax[l - 1] = height[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        // Math.min(leftMax[i], rightMax[i]) 将两个数组重叠，取较小值，该值表示height数组每个坐标上能保留的雨水高度。
        for (int i = 0; i < l; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
