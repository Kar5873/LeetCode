package com.leetcode.structure2.d02;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author Kar
 * @create 2021-12-06 下午4:52
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors2(new int[]{0,1,2});
    }

    // 方法三：双指针
    public void sortColors2(int[] nums) {
        int l = nums.length;
        int p0 = 0, p2 = l - 1;
        for (int i = 0; i <= p2; i++) {
            while (nums[i] == 2 && p2 >= i) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }


    // 方法二：双指针
    public void sortColors1(int[] nums) {
        int l = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }
        }
    }


    //方法一：单指针
    public void sortColors(int[] nums) {
        int l = nums.length;
        int ptr = 0;
        for (int i = ptr; i < l; i++) {
            if (nums[i] == 0) {
                int tmp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = tmp;
                ptr++;
            }
        }
        for (int i = ptr; i < l; i++) {
            if (nums[i] == 1) {
                int tmp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = tmp;
                ptr++;
            }
        }
    }
}
