package com.leetcode.dynamic.d03;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是
 * 相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author kar
 * @create 2021-11-27 21:40
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1,1}));
        System.out.println(robber.rob(new int[]{1,2,3,1}));
        System.out.println(robber.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(robber.rob(new int[]{2,1,1,2}));
    }
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l > 2) {
            nums[2] += nums[0];
        }
        for (int i = 3; i < l; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        return Math.max(nums[l - 1], nums[l - 2]);
    }
}
