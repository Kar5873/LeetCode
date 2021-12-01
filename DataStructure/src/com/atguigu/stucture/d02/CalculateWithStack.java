package com.atguigu.stucture.d02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
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

    public int calculate(String str) {
        String[] nums = str.replace(" ", "").split("[+*/\\-]");
        String[] oper = str.replace(" ", "").split("\\d");
        Deque<Integer> stackNum = new LinkedList<>();
        stackNum.push(Integer.valueOf(nums[0]));
        for (int i = 0; i < oper.length; i++) {
            if ("+".equals(oper[i])) {
                stackNum.push(Integer.parseInt(nums[i + 1]));
            }else if ("-".equals(oper[i])){
                stackNum.push(-Integer.parseInt(nums[i + 1]));
            } else {
                if ("*".equals(oper[i])) {
                    stackNum.push(stackNum.pop() * Integer.parseInt(nums[i + 1]));
                }else {
                    stackNum.push(stackNum.pop() / Integer.parseInt(nums[i + 1]));
                }
            }
        }
        int size = stackNum.size();
        for (int i = 0; i < size; i++) {

        }
        return 0;
    }
}
