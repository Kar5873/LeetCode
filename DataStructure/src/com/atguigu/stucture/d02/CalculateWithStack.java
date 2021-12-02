package com.atguigu.stucture.d02;

import java.util.ArrayDeque;
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
        System.out.println(calculate.calculate("12-3*4"));

    }

    public int calculate(String str) {
        String[] nums = str.replace(" ", "").split("[+*/\\-]");
        String[] oper = str.replace(" ", "").split("\\d+");
        Deque<Integer> stackNum = new LinkedList<>();
        stackNum.push(Integer.parseInt(nums[0]));
        for (int i = 1; i < oper.length; i++) {
            if ("+".equals(oper[i])) {
                stackNum.push(Integer.parseInt(nums[i]));
            } else if ("-".equals(oper[i])) {
                stackNum.push(-Integer.parseInt(nums[i]));
            } else {
                if ("*".equals(oper[i])) {
                    stackNum.push(stackNum.pop() * Integer.parseInt(nums[i]));
                } else {
                    stackNum.push(stackNum.pop() / Integer.parseInt(nums[i]));
                }
            }
        }
        int ans = 0;
        while (!stackNum.isEmpty()) {
            ans += stackNum.pop();
        }
        return ans;
    }

    //
    public int calculate1(String s) {
        s = s.replace(" ", "");
        Deque<Integer> q = new ArrayDeque<>();
        char flag = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                switch (flag) {
                    case '+':
                        q.push(num);
                        break;
                    case '-':
                        q.push(-num);
                        break;
                    case '*':
                        q.push(q.pop() * num);
                        break;
                    case '/':
                        q.push(q.pop() / num);
                        break;
                }
                flag = s.charAt(i);
                num = 0;
            }
        }
        while (!q.isEmpty()) {
            num += q.pop();
        }
        return num;
    }
}
