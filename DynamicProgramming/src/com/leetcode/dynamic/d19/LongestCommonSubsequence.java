package com.leetcode.dynamic.d19;

import com.leetcode.dynamic.d18.LongestIncreasingSubsequence;

/**
 * 1143. 最长公共子序列
 * <p>
 * 难度中等
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * <p>
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * @author kar
 * @create 2021-12-19 12:52
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    // 动态规划：
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        // 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 != c2) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
