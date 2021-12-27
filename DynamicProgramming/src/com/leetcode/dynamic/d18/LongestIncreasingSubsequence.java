package com.leetcode.dynamic.d18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. 最长递增子序列
 * <p>
 * 难度中等
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * @author kar
 * @create 2021-12-18 14:56
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        System.out.println(subsequence.lengthOfLIS(new int[]{0,8,4,12,2}));
    }

    // 贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 目前最长上升子序列的长度
        int len = 1;
        // 表示长度为 i 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        d[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (d[len] < nums[i]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len, position = 0;
                while (left <= right){
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]){
                        position = mid;
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
                d[position + 1] = nums[i];
            }
        }
        return len;
    }


    // 动态规划
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        // 考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
        int[] dp = new int[n];
        dp[0] = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
