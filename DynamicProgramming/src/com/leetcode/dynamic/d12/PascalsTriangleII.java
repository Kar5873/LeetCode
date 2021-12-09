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
        System.out.println(pascalsTriangleII.getRow1(3));
        System.out.println(pascalsTriangleII.getRow(5));
    }

    // 优化递推
    // 当前行第 i 项的计算只与上一行第 i−1 项及第 i 项有关。
    // 因此我们可以倒着计算当前行，这样计算到第 i 项时，第 i−1 项仍然是上一行的值。
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
    // 递推-滚动数组
    // 对第 i+1i+1 行的计算仅用到了第 i 行的数据
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
