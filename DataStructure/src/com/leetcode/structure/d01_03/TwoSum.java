package com.leetcode.structure.d01_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数字和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * @author kar
 * @create 2021-11-21 18:34
 */
public class TwoSum {
    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            throw new RuntimeException("数组长度至少为2");
        }
        for (int i = 0; i < nums.length; i++) {
            // 需要注意到每一个位于 i 之前的元素都已经和 i 匹配过，因此不需要再进行匹配。
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法二：哈希表
     *
     * 思路及算法
     *
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。
     * 因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     *
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
     *
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     *
     * 复杂度分析
     *      时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     *      空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
