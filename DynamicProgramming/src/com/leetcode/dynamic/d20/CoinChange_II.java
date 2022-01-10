package com.leetcode.dynamic.d20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 518. 零钱兑换 II
 * <p>
 * 难度中等
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 解题思路
 * 如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。
 *
 * for num in nums:
 *     for i in range(num, target + 1):
 *
 * 背包的组合问题，通用转移方程：
 *     dp[i] += dp[i - num]
 *
 * @author Kar
 * @create 2022-01-10 下午2:36
 */
public class CoinChange_II {
    public static void main(String[] args) {
        System.out.println(new CoinChange_II().change(11, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        // 表示金额之和等于 i 的硬币组合数
        int dp[] = new int[amount + 1];
        // amount为0，表示不需要硬币，也算一个组合
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
