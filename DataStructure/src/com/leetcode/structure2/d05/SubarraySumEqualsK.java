package com.leetcode.structure2.d05;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 难度中等
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * @author kar
 * @create 2021-12-11 16:49
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        subarraySumEqualsK.subarraySum1(new int[]{1, 1, 2, 1, 1}, 2);
    }

    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int pre = 0, count = 0;
        // 存放各个前缀和
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和直接等于k的情况
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    /**
     * 时间复杂度：O(n^2)，其中 n 为数组的长度。
     * 枚举子数组开头和结尾需要 O(n^2)的时间，其中求和需要 O(1) 的时间复杂度，因此总时间复杂度为 O(n^2)。
     * <p>
     * 空间复杂度：O(1)。只需要常数空间存放若干变量。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
