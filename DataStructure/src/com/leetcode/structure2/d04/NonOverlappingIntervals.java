package com.leetcode.structure2.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
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
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    }
}
