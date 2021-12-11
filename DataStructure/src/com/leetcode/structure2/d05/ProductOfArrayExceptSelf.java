package com.leetcode.structure2.d05;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 难度中等
 * <p>
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * 输入: [1,2,3,4]输出: [24,12,8,6]
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author kar
 * @create 2021-12-11 15:53
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf1(new int[]{1, 2, 3, 4})));
    }
    //方法二：空间复杂度 O(1)O(1) 的方法
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        int R = 1;
        for (int i = n-1; i >=0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }
    //方法一：左右乘积列表
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = nums[i-1] * L[i-1];
        }
        R[n-1] = 1;
        for (int i = n-2; i >=0; i--) {
            R[i] = nums[i+1] * R[i+1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
