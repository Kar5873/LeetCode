package com.leetcode.dynamic.d13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 难度中等
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author Kar
 * @create 2021-12-08 上午8:43
 */
public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        for (int[] ints : arr) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int anInt : ints) {
                integers.add(anInt);
            }
            lists.add(integers);
        }
        triangle.minimumTotal(lists);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
