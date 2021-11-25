package com.leetcode.structure.d06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * @author kar
 * @create 2021-11-25 21:12
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("rat", "car");
    }

    public boolean isAnagram(String s, String t) {
        int[] collect = new int[26];
        for (char c : s.toCharArray()) {
            collect[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (collect[c - 'a'] != 0) {
                collect[c - 'a']--;
            } else {
                return false;
            }
        }
        return Arrays.stream(collect).sum() == 0;
    }

    /**
     * 方法一：排序
     * t 是 s 的异位词等价于「两个字符串排序后相等」。因此我们可以对字符串 s 和 t 分别排序，看排序后的字符串是否相等即可判断。
     * 此外，如果 s 和 t 的长度不同，t 必然不是 s 的异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 方法二：哈希表
     * 从另一个角度考虑，t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。
     * 由于字符串只包含 26 个小写字母，因此我们可以维护一个长度为 26 的频次数组table，
     * 先遍历记录字符串 s 中字符出现的频次，然后遍历字符串 t，减去 table 中对应的频次，
     * 如果出现 table[i]<0，则说明 t 包含一个不在 s 中的额外字符，返回 false 即可。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

}
