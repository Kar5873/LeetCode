package com.leetcode.dynamic.d03;

import java.util.*;

/**
 * 删除并获得点数
 * <p>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * @author kar
 * @create 2021-11-28 10:39
 */
public class DeleteAndEarn {

    /**
     * HouseRobber的间接版，需要自己构建操作数组
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    private int rob(int[] sum) {
        int l = sum.length;
        int first = sum[0], second = Math.max(sum[0], sum[1]);
        for (int i = 2; i < l; i++) {
            int temp = second;
            second = Math.max(first + sum[i], second);
            first = temp;
        }
        return second;
    }

    /*
     * ***********************************************************
     */

    /**
     * 排序+动态规划
     *
     * 注意到若 nums 中不存在某个元素 x，则选择任一小于 x 的元素不会影响到大于 x 的元素的选择。
     * 因此我们可以将 nums 排序后，将其划分成若干连续子数组，子数组内任意相邻元素之差不超过 1。
     * 对每个子数组按照方法一的动态规划过程计算出结果，累加所有结果即为答案。
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + nums[i]);
            } else if (nums[i] == nums[i - 1] + 1) {
                sum.add(nums[i]);
                ++size;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(nums[i]);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
}
