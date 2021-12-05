package com.leetcode.dynamic.d09;

import java.util.*;

/**
 * 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：拆分时可以重复使用字典中的单词。
 *
 * @author kar
 * @create 2021-12-05 17:27
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        LinkedList<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("apple");
        list1.add("pen");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("cats");
        list2.add("dog");
        list2.add("sand");
        list2.add("and");
        list2.add("cat");
        // System.out.println(wordBreak.wordBreak("leetcode", list));
        // System.out.println(wordBreak.wordBreak("applepenapple", list1));
        System.out.println(wordBreak.wordBreak("catsandog", list2));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // dp表示空格，加上字符串前后总共s.length() + 1个空格
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 匹配字典的字符串需要保证前面的字段刚好能被分割出去，
                // 即匹配字典的字符串的起点对应dp的坐标为true，即有空格。
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
