package com.leetcode.dynamic.d11;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 264. 丑数 II
 * <p>
 * 难度中等
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * * 1 <= n <= 1690
 *
 * @author Kar
 * @create 2021-12-07 上午10:29
 */
public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();

        System.out.println(uglyNumberII.nthUglyNumber1(4));
    }

    // 方法二：动态规划
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2 ) p2++;
            if (dp[i] == dp[p3] * 3 ) p3++;
            if (dp[i] == dp[p5] * 5 ) p5++;
        }
        return dp[n];
    }


    // 方法一 ： 最小堆
    // 优先队列的作用是能保证每次取出的元素都是队列中权值最小的（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）。
    // 这里牵涉到了大小关系，元素大小的评判可以通过元素本身的自然顺序（natural ordering），
    // 也可以通过构造时传入的比较器（Comparator，类似于C++的仿函数）。
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
