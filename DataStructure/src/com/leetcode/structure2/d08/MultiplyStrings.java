package com.leetcode.structure2.d08;

/**
 * 43. 字符串相乘
 * 难度中等
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 说明：
 * 1.
 * num1 和 num2 的长度小于110。
 * 2.
 * num1 和 num2 只包含数字 0-9。
 * 3.
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 4.
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author kar
 * @create 2021-12-13 11:35
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("123456789123456789123456789", "1234567891234567891234566789"));
    }
    /*

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
    */


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuffer ans = new StringBuffer();
        int zero = 0;
        while (n1 > 0) {
            int add = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < zero; i++) {
                sb.append("0");
            }
            zero++;
            int v1 = num1.charAt(--n1) - '0';
            int curN2 = n2;
            while (curN2 > 0) {
                int v2 = num2.charAt(--curN2) - '0';
                int mul = v1 * v2 + add;
                sb.append(mul % 10);
                add = mul / 10;
            }
            if (add > 0) {
                sb.append(add);
            }
            addString(ans, sb);
        }
        return ans.reverse().toString();
    }
    // 这里的相加的字符串是反向的
    private void addString(StringBuffer ans, StringBuffer addStr) {
        int n1 = ans.length();
        int n2 = addStr.length();
        int add = 0;
        int i1 = 0, i2 = 0;
        while (i1 < n1 || i2 < n2 || add != 0) {
            int v1 = i1 < n1 ? ans.charAt(i1) - '0' : 0;
            int v2 = i2 < n2 ? addStr.charAt(i2++) - '0' : 0;
            add += v1 + v2;
            if (i1 < n1) {
                ans.setCharAt(i1++, (char) (add % 10 + '0'));
            } else {
                ans.append((char) (add % 10 + '0'));
            }
            add /= 10;
        }
    }
}
