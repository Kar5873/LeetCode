package com.leetcode.structure.d01_03;

/**
 * 2、买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 *
 * @author kar
 * @create 2021-11-22 22:04
 */
public class BuySellStock {
    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(buySellStock.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(buySellStock.maxProfit(new int[]{1,1,1,1}));

    }

    /**
     * 方法一：暴力法
     * 效率太低了。
     *
     * 复杂度分析
     *   时间复杂度：O(n^2)。循环运行 n(n−1)/2  次。
     *   空间复杂度：O(1)。只使用了常数个变量。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if(prices[j]>prices[i]){
                    max = Math.max(max, prices[j]- prices[i]);
                }
            }
        }
        return max;
    }

    /**
     * 我们只需要遍历价格数组一遍，记录历史最低点，然后在之后的每一天考虑这么一个问题：
     * 如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
