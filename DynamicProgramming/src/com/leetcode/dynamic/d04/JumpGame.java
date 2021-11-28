package com.leetcode.dynamic.d04;

/**
 * 4-1 跳跃游戏
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 1 - 就是说当前元素为0,就不能继续走
 * 2 - 当前元素为零，且不在最后一位，方法返回false
 * 3 - 遍历每个元素，维护一个最远可达坐标的值，当这个值大于等于length-1，方法返回true
 *
 * @author kar
 * @create 2021-11-28 11:50
 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{0}));
        System.out.println(jumpGame.canJump(new int[]{0, 1}));
        System.out.println(jumpGame.canJump(new int[]{1, 0, 1, 0}));
        System.out.println(jumpGame.canJump(new int[]{0, 2, 4, 4, 3, 0, 1, 4, 1}));
        System.out.println(jumpGame.canJump(new int[]{2, 0, 0}));
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame.canJump(new int[]{3, 3, 1, 0, 0,}));
    }

    public boolean canJump(int[] nums) {
        // 最远可以到达的坐标
        int arriveMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arriveMost >= i) {
                arriveMost = Math.max(i + nums[i], arriveMost);
                if (arriveMost >= nums.length -1 ) {
                    return true;
                }
            }
        }
        return false;
    }
}
