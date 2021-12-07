package com.leetcode.dynamic.d10;

/**
 * 91. 解码方法 难度中等
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * <p>
 * <p>
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @author kar
 * @create 2021-12-06 23:43
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings1("102023241526"));
    }

    // 简化
    public int numDecodings1(String s) {
        int n = s.length();
        int f1 = 1, f2 = 0, f;
        for (int i = 1; i <= n; i++) {
            f = 0;
            if (s.charAt(i - 1) != '0') {
                f += f1;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                f += f2;
            }
            f2 = f1;
            f1 = f;
        }
        return f1;
    }


    // 方法一：动态规划
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
