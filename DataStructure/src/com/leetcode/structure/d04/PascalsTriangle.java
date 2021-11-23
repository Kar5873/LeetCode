package com.leetcode.structure.d04;

import java.util.ArrayList;
import java.util.List;

/**
 *2、杨辉三角
 *
 * 题目：
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author kar
 * @create 2021-11-23 21:11
 */
public class PascalsTriangle {

    /**
     * 每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。
     * 即第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
