package com.leetcode.structure.d01_03;

import java.util.*;

/**
 * 1、两个数组的交集：
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 示例 3：
 *
 * 输入：nums1 = [1,2], nums2 = [2,1]
 * 输出：[1,2]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author kar
 * @create 2021-11-22 19:51
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(intersection.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 8, 4, 9})));
        System.out.println(Arrays.toString(intersection.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection.intersect(new int[]{4, 9, 5}, new int[]{})));
        System.out.println(Arrays.toString(intersection.intersect(new int[]{1, 2}, new int[]{2, 1})));
    }

    /**
     * 方法一：哈希表
     *
     *     由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。
     *     对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
     *
     *     首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，
     *     然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     *
     *     为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     * 方法二：排序 + 双指针
     *
     *     如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     *
     *     首先对两个数组进行排序，然后使用两个指针遍历两个数组。
     *
     *     初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，
     *     如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。
     *     当至少有一个指针超出数组范围时，遍历结束。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     * 结语
     *     如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中。
     *     那么就无法高效地对 nums2  进行排序，因此推荐使用方法一而不是方法二。
     *     在方法一中，nums2  只关系到查询操作，因此每次读取 nums2  中的一部分数据，并进行处理即可。
     */


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                intersection[index++] = i;
                count--;
                if (count > 0) {
                    map.put(i, count);
                }else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
