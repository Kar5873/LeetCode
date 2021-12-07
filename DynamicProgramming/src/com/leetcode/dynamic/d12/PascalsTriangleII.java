package com.leetcode.dynamic.d12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 难度简单
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author kar
 * @create 2021-12-07 22:37
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        System.out.println(pascalsTriangleII.getRow(3));
        System.out.println(pascalsTriangleII.getRow(5));
    }
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0|| j==i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
}
