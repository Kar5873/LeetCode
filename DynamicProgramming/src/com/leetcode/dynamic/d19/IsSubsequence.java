package com.leetcode.dynamic.d19;

import com.sun.corba.se.spi.orbutil.fsm.FSM;

/**
 * 392. 判断子序列
 * 难度简单
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @author kar
 * @create 2021-12-18 21:14
 */
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    // 方法二：动态规划
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j+'a'){
                    f[i][j] = i;
                }else {
                    f[i][j] = f[i+1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m){
                return false;
            }
            add = f[add][s.charAt(i)-'a'] + 1;
        }
        return true;
    }


    // 双指针
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }


    public boolean isSubsequence1(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return true;
        }
        if (n > m) {
            return false;
        }
        int pos = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(pos) == t.charAt(i)) {
                if (++pos == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
