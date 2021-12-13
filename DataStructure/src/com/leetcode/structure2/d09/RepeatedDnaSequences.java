package com.leetcode.structure2.d09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * 难度中等
 * <p>
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * @author kar
 * @create 2021-12-13 15:22
 */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        RepeatedDnaSequences repeatedDnaSequences = new RepeatedDnaSequences();
        System.out.println(repeatedDnaSequences.findRepeatedDnaSequences1("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int cur = 0;
        // 先获取前9位子串
        for (int i = 0; i <= L - 2; i++) {
            cur = (cur << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - L; i++) {
            // cur左移两位，空出的低位补新字符
            // & (1 << (L * 2) - 1) 将超出20位的数字置零，
            cur = ((cur << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.get(cur) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }
}