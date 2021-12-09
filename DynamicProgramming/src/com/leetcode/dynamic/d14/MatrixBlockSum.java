package com.leetcode.dynamic.d14;

/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * * i - k <= r <= i + k,
 * * j - k <= c <= j + k 且
 * * (r, c) 在矩阵内。
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 *
 * @author Kar
 * @create 2021-12-09 上午11:07
 */
public class MatrixBlockSum {
    public static void main(String[] args) {
        // mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        matrixBlockSum.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = Math.max(0, i - k);
                int rowEnd = Math.min(i + k, m-1);
                int col = Math.max(0, j - k);
                int colENd = Math.min(j + k, n-1);
                for (int l = row; l <= rowEnd; l++) {
                    for (int o = col; o <= colENd; o++) {
                        answer[i][j] += mat[l][o];
                    }
                }
            }
        }
        return answer;
    }
}
