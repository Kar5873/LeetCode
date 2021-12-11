package com.leetcode.structure2.d06;

import java.util.Arrays;

/**
 * 415. 字符串相加
 * 难度简单
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * @author kar
 * @create 2021-12-11 19:08
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("12345", "1234567"));
        System.out.println(addStrings.addStrings("0", "0"));
        System.out.println(addStrings.addStrings("9", "99"));
    }


    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuffer ans = new StringBuffer();
        int add = 0;
        while (n1 > 0 || n2 > 0 || add == 1) {
            n1--;
            n2--;
            // 对位数较短的数字进行补零操作
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            ans.append((char) ((add + x + y) % 10 + '0'));
            add = (add + x + y) / 10;
        }
        return ans.reverse().toString();
    }

}
