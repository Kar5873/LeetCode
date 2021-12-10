package com.leetcode.structure2.d04;

/**
 * 240. 搜索二维矩阵 II
 * <p>
 * 难度中等
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * * 每行的元素从左到右升序排列。
 * * 每列的元素从上到下升序排列。
 *
 * @author Kar
 * @create 2021-12-10 下午3:21
 */
public class SearchA2dMatrixII {

    // 方法三：Z 字形查找
    // 从右上角开始查找，
    // 大于target则往左移动，小于target则往下移动。
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        return false;
    }
}
