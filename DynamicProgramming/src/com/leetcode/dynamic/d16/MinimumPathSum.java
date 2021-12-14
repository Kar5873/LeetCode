package com.leetcode.dynamic.d16;

/**
 * 64. 最小路径和
 * <p>
 * 难度中等
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author Kar
 * @create 2021-12-14 下午3:48
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

    }

    // 动态规划，最小路径和dp[i][j]的值+=上方dp或左方dp的最小值
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i > 0 /*&& j == 0*/) {
                    grid[i][j] += grid[i-1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
