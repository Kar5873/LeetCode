package com.leetcode.dynamic.d19;

/**
 * 72. 编辑距离
 * 难度困难
 * https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @author kar
 * @create 2021-12-19 14:39
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        int i = editDistance.minDistance("horse", "ros");
        System.out.println(i);
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // 空串
        if (n * m == 0) {
            return n + m;
        }
        // 临界值初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down++;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }
}
