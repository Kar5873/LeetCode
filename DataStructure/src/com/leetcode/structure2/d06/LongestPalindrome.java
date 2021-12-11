package com.leetcode.structure2.d06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 409. 最长回文串
 * 难度简单
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * @author kar
 * @create 2021-12-11 21:43
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome2("abcccccdd"));
        System.out.println(longestPalindrome.longestPalindrome2("aa"));
        System.out.println(longestPalindrome.longestPalindrome2("ccc"));
        System.out.println(longestPalindrome.longestPalindrome2("Aa"));
    }

    // 统计奇数次数，反推最长的回文串长度
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i : count) {
            odd += i % 2;
        }
        return odd == 0 ? s.length() : s.length() - odd + 1;
    }

    // 使用数组
    public int longestPalindrome1(String s) {
        // ASCII 值的范围为 [0, 128)
        int[] count = new int[128];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i : count) {
            ans += i / 2 * 2;
            if (i % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    // 使用哈希表
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        int single = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                count += value;
            } else {
                single = 1;
                count += --value;
            }
        }
        return count + single;
    }
}
