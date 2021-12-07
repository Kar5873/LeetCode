package com.leetcode.dynamic.d13;

/**
 * 931. 下降路径最小和
 * 难度中等
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
 * （即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是
 * (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * @author kar
 * @create 2021-12-07 22:55
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i < n; i++) {
                int min = matrix[row + 1][i];
                if (i > 0) {
                    min = Math.min(min, matrix[row + 1][i - 1]);
                }
                if (i < n - 1) {
                    min = Math.min(min, matrix[row + 1][i + 1]);
                }
                matrix[row][i] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, matrix[0][i]);
        }
        return ans;
    }
}
