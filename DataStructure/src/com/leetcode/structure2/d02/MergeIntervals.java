package com.leetcode.structure2.d02;

import java.util.*;

/**
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author Kar
 * @create 2021-12-06 下午5:52
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}})));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{})));
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int[] merge = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= merge[1]) {
                merge[1] = Math.max(merge[1], interval[1]);
            } else {
                list.add(merge);
                merge = interval;
            }
        }
        list.add(merge);
        return list.toArray(new int[list.size()][]);
    }

    // 这里相较于上一个方法少了一个数组，节省了一点空间。
    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
