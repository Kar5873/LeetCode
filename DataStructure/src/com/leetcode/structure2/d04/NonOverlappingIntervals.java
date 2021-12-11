package com.leetcode.structure2.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * <p>
 * 难度中等
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 1. 可以认为区间的终点总是大于它的起点。
 * 2. 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * @author Kar
 * @create 2021-12-10 下午4:58
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals1(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
    // 贪心算法
    public int eraseOverlapIntervals1(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int right = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0]>= right){
                count++;
                right = intervals[i][1];
            }
        }
        return n-count;
    }

    // 超出时间限制
    // 题目的要求等价于「选出最多数量的区间，使得它们互不重叠」。
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        // 令 f[i] 表示「以区间 i 为最后一个区间，可以选出的不重叠区间数量的最大值」
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
