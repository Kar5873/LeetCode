package com.leetcode.structure2.d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 *
 * @author Kar
 * @create 2021-12-06 下午3:36
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums.length;
        if (l < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < l; i++) {
            if (nums[i] > 0) break; // 首位大于0，表明三数之和必然大于0
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int second = i + 1;
            int third = l - 1;
            while (second < third) {
                int sum = nums[i] + nums[second] + nums[third];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[second], nums[third]));
                    while (second < third && nums[second] == nums[second + 1]) second++; //去重
                    while (second < third && nums[third] == nums[third - 1]) third--; //去重
                    second++;
                    third--;
                } else if (sum < 0) second++;
                else third--;
            }

        }
        return ans;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        if (l < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举a
        for (int first = 0; first < l; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = l - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < l; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[third] + nums[second] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[third] + nums[second] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
