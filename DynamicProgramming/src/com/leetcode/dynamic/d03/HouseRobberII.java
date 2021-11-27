package com.leetcode.dynamic.d03;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * @author kar
 * @create 2021-11-27 22:13
 */
public class HouseRobberII {
    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
        System.out.println(robber.rob(new int[]{1, 1}));//1
        System.out.println(robber.rob(new int[]{1, 2, 3, 1}));//3
        System.out.println(robber.rob(new int[]{2, 7, 9, 3, 1}));//11
        System.out.println(robber.rob(new int[]{2, 1, 1, 2}));//3
        System.out.println(robber.rob(new int[]{1, 2, 3, 4, 5}));//8
    }

    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l == 2) {
            return Math.max(nums[1], nums[0]);
        }
        // 抢头不抢尾，抢尾不抢头
        return Math.max(robRage(nums, 0, l - 2), robRage(nums, 1, l - 1));
    }

    private int robRage(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
