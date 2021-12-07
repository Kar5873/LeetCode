package com.leetcode.dynamic.d12;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 难度简单
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author Kar
 * @create 2021-12-07 下午12:37
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] dp = new int[numRows+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= numRows; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }

    }
}
