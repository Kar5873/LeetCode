package com.leetcode.dynamic.d15;

/**
 * @author Kar
 * @create 2021-12-09 下午4:06
 */
public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles1(new int[][]{{0, 0, 0, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}}));
    }

    // 空间复杂度：O(n)
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[j][i] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[j][i] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n-1];
    }


    // 空间复杂度：O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
