package com.leetcode.dynamic.d12;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 难度简单
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author Kar
 * @create 2021-12-07 下午12:37
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(1));
        System.out.println(pascalsTriangle.generate(3));
        System.out.println(pascalsTriangle.generate(10));

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j==i){
                    list.add(1);
                }else {
                    list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
