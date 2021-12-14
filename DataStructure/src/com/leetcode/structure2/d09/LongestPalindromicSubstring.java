package com.leetcode.structure2.d09;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. 最长回文子串
 * 难度中等
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author kar
 * @create 2021-12-13 17:22
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("ababd"));
    }

    // 同样是方法三：Manacher 算法
    public String longestPalindrome(String s) {
        int charLen = s.length();//源字符串的长度
        int length = charLen * 2 + 1;//添加特殊字符之后的长度
        char[] chars = s.toCharArray();//源字符串的字符数组
        char[] res = new char[length];//添加特殊字符的字符数组
        int index = 0;
        //添加特殊字符
        for (int i = 0; i < res.length; i++) {
            res[i] = (i % 2) == 0 ? '#' : chars[index++];
        }

        //新建p数组 ，p[i]表示以res[i]为中心的回文串半径
        int[] p = new int[length];
        //maxRight(某个回文串延伸到的最右边下标)
        //maxCenter(maxRight所属回文串中心下标),
        //resCenter（记录遍历过的最大回文串中心下标）
        //resLen（记录遍历过的最大回文半径）
        int maxRight = 0, maxCenter = 0, resCenter = 0, resLen = 0;
        //遍历字符数组res
        for (int i = 0; i < length; i++) {
            if (i < maxRight) {
                //情况一，i没有超出范围[left,maxRight]
                //2 * maxCenter - i其实就是j的位置，实际上是判断p[j]<maxRight - i
                if (p[2 * maxCenter - i] < maxRight - i) {
                    //j的回文半径没有超出范围[left,maxRight]，直接让p[i]=p[j]即可
                    p[i] = p[2 * maxCenter - i];
                } else {
                    //情况二，j的回文半径已经超出了范围[left,maxRight]，我们可以确定p[i]的最小值
                    //是maxRight - i，至于到底有多大，后面还需要在计算
                    p[i] = maxRight - i;
                    while (i - p[i] >= 0 && i + p[i] < length && res[i - p[i]] == res[i + p[i]])
                        p[i]++;
                }
            } else {
                //情况三，i超出了范围[left,maxRight]，就没法利用之前的已知数据，而是要一个个判断了
                p[i] = 1;
                while (i - p[i] >= 0 && i + p[i] < length && res[i - p[i]] == res[i + p[i]])
                    p[i]++;
            }
            //匹配完之后，如果右边界i + p[i]超过maxRight，那么就更新maxRight和maxCenter
            if (i + p[i] > maxRight) {
                maxRight = i + p[i];
                maxCenter = i;
            }
            //记录最长回文串的半径和中心位置
            if (p[i] > resLen) {
                resLen = p[i];
                resCenter = i;
            }
        }
        //计算最长回文串的长度和开始的位置
        resLen = resLen - 1;
        int start = (resCenter - resLen) >> 1;
        //截取最长回文子串
        return s.substring(start, start + resLen);
    }

    // 方法三：Manacher 算法
    public String longestPalindrome4(String s) {
        int start = 0, end = -1;
        // 将偶数串 转为 奇数串
        StringBuffer t = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            t.append('#');
            t.append(s.charAt(i));
        }
        t.append('#');
        s = t.toString();
        ArrayList<Integer> arm_len = new ArrayList<>();
        // 记录字符串的检索到的右边界和其回文串对应的中心。
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur_arm_len;
            if (right >= i) {
                // i_sym：i关于j的对称点
                int i_sym = j * 2 - i;
                // 获取i的已知最小臂长
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            // 记录每个坐标的臂长
            arm_len.add(cur_arm_len);
            // 更新右边界和回文串中心，非最长回文串。
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }


    // 方法二：中心扩展算法
    public String longestPalindrome3(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 0;
        int core = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (maxLen < len) {
                maxLen = len;
                core = i;
            }
        }
        return s.substring(core - (maxLen - 1) / 2, core + maxLen / 2 + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // -1 是因为此时left、right在边界外。
        return right - left - 1;
    }


    // 动态规划
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        // 记录最长回文子串长度
        int maxLen = 1;
        // 子串起点
        int begin = 0;
        // dp[i][j]表示子串s[i,j]是否回文
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 枚举子串长度
        for (int L = 2; L < n; L++) {
            for (int i = 0; i < n; i++) {
                // 右边界
                int j = i + L - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    // 超出时间限制
    public String longestPalindrome1(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= i; j--) {
                StringBuffer sub = new StringBuffer(s.substring(i, j));
                if (sub.toString().equals(sub.reverse().toString())) {
                    list.add(sub.toString());
                }
            }
        }
        String maxStr = "";
        for (int i = 0; i < list.size(); i++) {
            maxStr = list.get(i).length() > maxStr.length() ? list.get(i) : maxStr;
        }
        return maxStr;
    }
}
