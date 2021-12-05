package com.leetcode.dynamic.d07;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author Kar
 * @create 2021-12-01 上午11:18
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock time = new BestTimeToBuyAndSellStock();
        System.out.println(time.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int l = prices.length;
        int minPri = prices[0];
        int maxBuff = 0;
        for (int i = 1; i < l; i++) {
            minPri = Math.min(prices[i], minPri);
            maxBuff = Math.max(prices[i] - minPri, maxBuff);
        }
        return maxBuff;
    }
}
