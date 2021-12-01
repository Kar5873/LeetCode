package com.leetcode.dynamic.d07;

/**
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
