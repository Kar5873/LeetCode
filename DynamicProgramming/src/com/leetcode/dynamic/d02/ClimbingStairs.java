package com.leetcode.dynamic.d02;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * @author kar
 * @create 2021-11-27 14:40
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs1(9));
    }

    /**
     * f(n) = f(n-1)+ f(n-2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <=2 ){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs1(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
