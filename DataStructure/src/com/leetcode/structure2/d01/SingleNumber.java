package com.leetcode.structure2.d01;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author Kar
 * @create 2021-12-06 下午2:41
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{2, 2, 1}));
    }

    /**
     * 方法一：位运算
     * 如果不考虑时间复杂度和空间复杂度的限制，这道题有很多种解法，可能的解法有如下几种。
     *
     * 使用集合存储数字。遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合，
     * 如果集合中已经有该数字，则将该数字从集合中删除，最后剩下的数字就是只出现一次的数字。
     *
     * 使用哈希表存储每个数字和该数字出现的次数。遍历数组即可得到每个数字出现的次数，
     * 并更新哈希表，最后遍历哈希表，得到只出现一次的数字。
     *
     * 使用集合存储数组中出现的所有数字，并计算数组中的元素之和。由于集合保证元素无重复，
     * 因此计算集合中的所有元素之和的两倍，即为每个元素出现两次的情况下的元素之和。
     * 由于数组中只有一个元素出现一次，其余元素都出现两次，因此用集合中的元素之和的两倍减去数组中的元素之和，
     * 剩下的数就是数组中只出现一次的数字。
     *
     * 上述三种解法都需要额外使用 O(n) 的空间，其中 nn 是数组长度。
     *
     * 如何才能做到线性时间复杂度和常数空间复杂度呢？
     *
     * 答案是使用位运算。对于这道题，可使用异或运算 \oplus⊕。异或运算有以下三个性质。
     *
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
           single ^= num;
        }
        return single;
    }
}