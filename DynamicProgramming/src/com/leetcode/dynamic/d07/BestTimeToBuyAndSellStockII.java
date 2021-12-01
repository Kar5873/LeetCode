package com.leetcode.dynamic.d07;

/**
 * 7-3 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Kar
 * @create 2021-12-01 上午11:32
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII time = new BestTimeToBuyAndSellStockII();
        System.out.println(time.maxProfit(new int[]{7, 3, 1, 4, 2, 5}));
    }

    public int maxProfit(int[] prices) {
        int l = prices.length;
        int buff = 0;
        for (int i = 1; i < l; i++) {
            // 只要第二天是涨的就买入
            buff += Math.max(0, prices[i]-prices[i-1]);
        }
        return buff;
    }


    public int maxProfit1(int[] prices) {
        int l = prices.length;
        int maxBuffSum = 0;
        int maxBuff = 0;
        int minPri = prices[0];
        int maxPri = prices[0];
        for (int i = 1; i < l; i++) {
            if (prices[i] > prices[i - 1]) {
                maxPri = prices[i];
            } else {
                maxPri = minPri = prices[i];
                maxBuffSum += maxBuff;
            }
            maxBuff = maxPri - minPri;
        }
        return maxBuffSum + maxBuff;
    }
}
