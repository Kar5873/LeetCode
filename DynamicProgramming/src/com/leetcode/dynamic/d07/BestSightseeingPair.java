package com.leetcode.dynamic.d07;

/**
 * 1 、最佳观光组合
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * @author Kar
 * @create 2021-12-01 上午8:47
 */
public class BestSightseeingPair {
    // 求values[i] + values[j] + i - j 的最大值
    // 其中values[j]-j是固定不变的，求上面的最大值，其实是求values[i] + i的最大值
    public int maxScoreSightseeingPair(int[] values) {
        int l = values.length;
        int max = 0, preMax = values[0] + 0;
        for (int i = 1; i < l; i++) {
            max = Math.max(preMax + values[i] - i, max);
            // 在遍历的过程中维护values[i] + i的最大值。
            preMax = Math.max(preMax, values[i] + i);
        }
        return max;
    }
}
