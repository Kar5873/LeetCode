package com.leetcode.dynamic.d05;

/**
 * @author kar
 * @create 2021-11-30 0:18
 */
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        MaximumSumCircularSubarray subarray = new MaximumSumCircularSubarray();
        System.out.println(subarray.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(subarray.maxSubarraySumCircular(new int[]{1, 2, 3, 4}));
        System.out.println(subarray.maxSubarraySumCircular(new int[]{2, -1, -1, 2}));
        System.out.println(subarray.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(subarray.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(subarray.maxSubarraySumCircular(new int[]{-2, -3, -1}));
}

    // 方法 1：邻接数组
    // 循环数组的子段可以被分成 单区间 子段或者 双区间 子段，取决于定长数组 A 需要多少区间去表示。
    public int maxSubarraySumCircular1(int[] nums) {
        int l = nums.length;
        int max = nums[0], sum = 0;
        // 1.计算单区间字段最大和
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(sum, max);
        }
        // 2.右子区间的各个子段和
        int[] rightSum = new int[l];
        rightSum[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        // 3.右子区间的各个子段的最大和
        int[] rightMax = new int[l];
        rightMax[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], rightSum[i]);
        }
        // 4.遍历左子区间和右子区间的最大和
        int leftSum = 0;
        for (int i = 0; i < l-2; i++) {
            leftSum += nums[i];
            max = Math.max(max, leftSum + rightMax[i+2]);
        }
        return max;
    }

    // 1：最大数组和在中间，和平时一样解法
    // 2：最大数组和是跨越头尾，则从两边出发往中间靠拢必须都是最大，那就说明中间段就是最小
    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0],max = dp, sum = dp,min = 0;
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }
        dp = nums[0];
        for(int i = 1; i < nums.length -1; i++){
            dp = nums[i] + Math.min(0,dp);
            min = Math.min(dp,min);
        }
        return Math.max(sum-min,max);
    }

}
