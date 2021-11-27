package com.leetcode.dynamic.d01;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * @author kar
 * @create 2021-11-25 22:06
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fib = new FibonacciNumber();
        for (int i = 0; i < 10; i++) {
            System.out.println(fib.fib(i));
        }
    }
    public int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契数存在递推关系
     *
     * 根据状态转移方程和边界条件，可以得到时间复杂度和空间复杂度都是 O(n) 的实现。由于 F(n) 只和 F(n−1) 与 F(n−2) 有关，
     * 因此可以使用「滚动数组思想」把空间复杂度优化成 O(1)。
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
