package com.leetcode.structure.d04;

/**
 * 1、重塑矩阵
 *
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 *
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 *
 *
 * @author kar
 * @create 2021-11-23 21:01
 */
public class ReshapeMatrix {

    /**
     *

     1、将二维数组 mat 映射成一个一维数组；
     2、将这个一维数组映射回 r 行 c 列的二维数组。
     我们当然可以直接使用一个一维数组进行过渡，但我们也可以直接从二维数组 mat 得到 r 行 c 列的重塑矩阵：
     3、设 mat 本身为 m 行 n 列，如果 mn != rc，那么二者包含的元素个数不相同，因此无法进行重塑；
     4、否则，对 x∈[0,mn)，第 x 个元素在 mat 中对应的下标为 (x / n, x % n)，而在新的重塑矩阵中对应的下标为 (x / c, x % c)。我们直接进行赋值即可。

     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        } else {
            int[][] newMat = new int[r][c];
            for (int i = 0; i < m*n; i++) {
                newMat[i/c][i%c] = mat[i/n][i%n];
            }
            return newMat;
        }
    }

    /**
     * myself
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        } else {
            int[][] newMat = new int[r][c];
            int r1 = 0;
            int c1 = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newMat[r1][c1] = mat[i][j];
                    if (r1 < r) {
                        c1++;
                        if (c1 == c) {
                            r1++;
                            c1 = 0;
                        }
                    }
                }
            }
            return newMat;
        }
    }

}
