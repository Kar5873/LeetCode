package com.leetcode.structure.d06;

import java.util.HashMap;
import java.util.Map;

/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 * <p>
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 * <p>
 * 如果可以构成，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @author kar
 * @create 2021-11-25 20:29
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] maga = magazine.toCharArray();
        for (char c : maga) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] ransom = ransomNote.toCharArray();
        for (char c : ransom) {
            if (map.containsKey(c)) {
                int tmp = map.get(c) - 1;
                if (tmp < 0) {
                    return false;
                }
                map.put(c, tmp);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] collect = new int[26];
        for (char c : magazine.toCharArray()) {
            collect[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (collect[c - 'a'] > 0) {
                collect[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
