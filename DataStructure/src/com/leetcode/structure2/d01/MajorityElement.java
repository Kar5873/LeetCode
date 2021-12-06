package com.leetcode.structure2.d01;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author Kar
 * @create 2021-12-06 下午3:03
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    // 排序
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //方法五：Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int check = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                check = num;
            }
            count += check == num ? 1 : -1;
        }
        return check;
    }
}
