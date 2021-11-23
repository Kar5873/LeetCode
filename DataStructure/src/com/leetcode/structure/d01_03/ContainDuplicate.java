package com.leetcode.structure.d01_03;

import com.leetcode.utils.CountTime;

import java.util.*;

/**
 * 题目：
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * @author kar
 * @create 2021-11-20 12:39
 */
public class ContainDuplicate {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 65536; i++) {
            list.add((int) (Math.random()*1000+1));
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        CountTime.start();
        if (containsDuplicate(arr)){
            System.out.println("cost time: "+CountTime.stop());
        }
        CountTime.start();
        if (containsDuplicate1(arr)) {
            System.out.println("cost time: "+CountTime.stop());
        }
    }

    /**
     * 1）排序
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                System.out.println(num);
                return true;
            }
        }
        return false;
    }

    /**
     * 2）哈希表
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    System.out.println(nums[i]);
                    return true;
                }
            }
        }
        return false;
    }
}
