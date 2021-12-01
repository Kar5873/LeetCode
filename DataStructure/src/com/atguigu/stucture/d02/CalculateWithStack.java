package com.atguigu.stucture.d02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * @author Kar
 * @create 2021-12-01 下午5:14
 */
public class CalculateWithStack {
    public static void main(String[] args) {
        CalculateWithStack calculate = new CalculateWithStack();
        calculate.calculate(" 3+2 * 2");

    }
    public int calculate(String str){
        String[] split = str.replace(" ", "").split("\\+|\\*|/|-| ");
        return 0;
    }
}
