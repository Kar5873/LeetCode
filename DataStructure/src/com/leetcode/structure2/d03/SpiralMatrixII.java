package com.leetcode.structure2.d03;

import com.sun.jnlp.ApiDialog;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 难度中等
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * @author Kar
 * @create 2021-12-10 下午2:01
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix1(1)));
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix1(2)));
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix1(3)));
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix1(4)));
    }

    // 方法二：按层模拟
    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        int val = 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                ans[top][col] = val++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                ans[row][right] = val++;
            }
            for (int col = right - 1; col >= left; col--) {
                ans[bottom][col] = val++;
            }
            for (int row = bottom - 1; row > top; row--) {
                ans[row][left] = val++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    // 方法一：模拟
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        // 填写数据的方向，右下左上（循环）
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int val = 1;
        int index = 0;
        while (val <= n * n) {
            ans[row][col] = val++;
            int nextRow = row + direction[index][0];
            int nextCol = col + direction[index][1];
            if (nextRow >= n || nextCol >= n ||
                    nextRow < 0 || nextCol < 0 ||
                    ans[nextRow][nextCol] != 0) {
                // 遇到边界或填写过，就转向
                index = (index + 1) % 4;
            }
            row = row + direction[index][0];
            col = col + direction[index][1];
        }
        return ans;
    }
}
