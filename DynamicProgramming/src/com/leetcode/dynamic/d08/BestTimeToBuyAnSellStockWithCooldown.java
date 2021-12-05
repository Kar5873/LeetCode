package com.leetcode.dynamic.d08;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * @author kar
 * @create 2021-12-05 11:47
 */
public class BestTimeToBuyAnSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        // f0: 手上持有股票的最大收益
        // f1: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f2: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int f0 = -prices[0], f1 = 0, f2 = 0;
        for (int i = 1; i < l; i++) {
            f0 = Math.max(f0, f2 - prices[i]);
            int new_f1 = f0 + prices[i];
            f2 = Math.max(f1, f2);
            f1 = new_f1;
        }
        return Math.max(f1, f2);
    }

    public int maxProfit1(int[] prices) {
        int l = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[l][3];
        f[0][0] = -prices[0]; // 买入为负收益
        for (int i = 1; i < l; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[l - 1][1], f[l - 1][2]);
    }
}
