package com.leetcode.dynamic.d08;

import com.leetcode.dynamic.d07.BestTimeToBuyAndSellStockII;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @author kar
 * @create 2021-12-05 16:08
 */
public class BestTimeToBuyAndSellStockWithFransactionFee {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithFransactionFee time = new BestTimeToBuyAndSellStockWithFransactionFee();
        System.out.println(time.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(time.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    // 贪心算法
    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        // 买入时价格
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 0; i < l; i++) {
            if (prices[i] + fee < buy) {
                // 今天买入更划算
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 今天卖出有赚
                profit += prices[i] - buy;
                // 也许之后更赚
                buy = prices[i];
            }
        }
        return profit;
    }

    // 简化 动态规划
    public int maxProfit2(int[] prices, int fee) {
        int l = prices.length;
        // 买入时付手续费
        int dp0 = -prices[0] - fee;
        int dp1 = 0;
        for (int i = 1; i < l; i++) {
            // 买入时收益
            int new_dp0 = Math.max(dp1 - prices[i] - fee, dp0);
            // 卖出时收益
            dp1 = Math.max(dp1, dp0 + prices[i]);
            dp0 = new_dp0;
        }
        return dp1;
    }

    // 动态规划
    public int maxProfit1(int[] prices, int fee) {
        int l = prices.length;
        int[][] dp = new int[l][2];
        // 买入时付手续费
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < l; i++) {
            // 买入时收益
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i] - fee, dp[i - 1][0]);
            // 卖出时收益
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[l - 1][1];
    }
}
