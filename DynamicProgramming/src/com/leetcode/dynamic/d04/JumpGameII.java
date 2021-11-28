package com.leetcode.dynamic.d04;

/**
 * 4-2 跳跃游戏II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author kar
 * @create 2021-11-28 12:52
 */
public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();
        // System.out.println(jumpGame.jump(new int[]{0}));
        System.out.println(jumpGame.jump(new int[]{1}));
        System.out.println(jumpGame.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
        // System.out.println(jumpGame.jump(new int[]{0, 1}));
        // System.out.println(jumpGame.jump(new int[]{1, 0, 1, 0}));
        // System.out.println(jumpGame.jump(new int[]{0, 2, 4, 4, 3, 0, 1, 4, 1}));
        System.out.println(jumpGame.jump(new int[]{2, 0, 0}));
        // System.out.println(jumpGame.jump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame.jump(new int[]{3, 3, 1, 0, 0,}));
    }

    /**
     * 方法二：正向查找可到达的最大位置
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int l = nums.length;
        int arrive = 0;
        // 边界坐标
        int edge = 0;
        int jump = 0;
        // 由于题设一定能到达最后一个位置，这里就不访问最后一个位置。
        // 因为如果最后一个位置刚好是边界的话，会增加额外的跳跃次数。
        for (int i = 0; i < l-1; i++) {
            // 获取最远可以到达的坐标
            arrive = Math.max(i+nums[i],arrive);
            // 遍历到达边界，用最远可达坐标更新边界，增加一次跳跃
            if (i == edge){
                jump++;
                edge = arrive;
            }
        }
        return jump;
    }

    /**
     * 方法一：反向查找出发位置
     * 我们的目标是到达数组的最后一个位置，因此我们可以考虑最后一步跳跃前所在的位置，该位置通过跳跃能够到达最后一个位置。
     *
     * 如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？直观上来看，我们可以「贪心」地选择距离最后一个位置最远的那个位置，
     * 也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
     *
     * 找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置。
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
