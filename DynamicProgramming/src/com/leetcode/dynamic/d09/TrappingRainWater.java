package com.leetcode.dynamic.d09;

import java.util.Deque;
import java.util.LinkedList;

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
        System.out.println(water.trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(water.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(water.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(water.trap1(new int[]{4, 2, 0, 3, 2, 5}));
    }

    // 双指针
    public int trap2(int[] height) {
        int ans = 0;
        int l = height.length;
        int left = 0, leftMax = 0, right = l - 1, rightmax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightmax = Math.max(height[right], rightmax);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            } else {
                ans+= rightmax - height[right];
                right--;
            }
        }
        return ans;
    }


    public int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int l = height.length;
        for (int i = 0; i < l; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 从左到右遍历数组，遍历到下标 ii 时，如果栈内至少有两个元素，记栈顶元素为 top，top 的下面一个元素是 left，
                // 则一定有 height[left]≥height[top]。
                int top = stack.pop();
                if (stack.isEmpty()) {
                    // 这里表明栈内只有一个元素，即没有左边界，雨水流走。
                    break;
                }
                int left = stack.peek();
                int currWith = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWith * currHeight;
            }
            // 维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height 中的元素递减。
            stack.push(i);
        }
        return ans;
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
