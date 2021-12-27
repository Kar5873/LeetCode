package com.leetcode.dynamic.d18;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 376. 摆动序列
 * 难度中等
 * <p>
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * <p>
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度完成此题?
 *
 * @author kar
 * @create 2021-12-18 17:21
 */
public class WigglesSubsequence {
    public static void main(String[] args) {
        WigglesSubsequence wigglesSubsequence = new WigglesSubsequence();
        System.out.println(wigglesSubsequence.wiggleMaxLength(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15}));
    }

    // 贪心
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int preDiff = nums[1] - nums[0];
        int ans = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = diff;
            }
        }
        return ans;
    }


    // 优化的动态规划
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            } else if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            }
        }
        return Math.max(up, down);
    }

    // 动态规划：上升和下降摆动序列
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else if (nums[i] > nums[i - 1]) {
                down[i] = down[i - 1];
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
