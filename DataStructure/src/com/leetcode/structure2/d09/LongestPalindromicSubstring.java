package com.leetcode.structure2.d09;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. 最长回文子串
 * 难度中等
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author kar
 * @create 2021-12-13 17:22
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("ababd"));
    }

    // 方法二：中心扩展算法
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 0;
        int core = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (maxLen < len) {
                maxLen = len;
                core = i;
            }
        }
        return s.substring(core - (maxLen - 1) / 2, core + maxLen / 2 + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // 动态规划
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        // 记录最长回文子串长度
        int maxLen = 1;
        // 子串起点
        int begin = 0;
        // dp[i][j]表示子串s[i,j]是否回文
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 枚举子串长度
        for (int L = 2; L < n; L++) {
            for (int i = 0; i < n; i++) {
                // 右边界
                int j = i + L - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    // 超出时间限制
    public String longestPalindrome1(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= i; j--) {
                StringBuffer sub = new StringBuffer(s.substring(i, j));
                if (sub.toString().equals(sub.reverse().toString())) {
                    list.add(sub.toString());
                }
            }
        }
        String maxStr = "";
        for (int i = 0; i < list.size(); i++) {
            maxStr = list.get(i).length() > maxStr.length() ? list.get(i) : maxStr;
        }
        return maxStr;
    }
}
