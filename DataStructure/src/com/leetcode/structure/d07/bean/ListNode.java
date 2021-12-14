package com.leetcode.structure.d07.bean;

/**
 * @author kar
 * @create 2021-11-26 22:50
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String output = "[" + val;
        ListNode tmp = next;
        while (tmp != null) {
            output += "," + tmp.val;
            tmp = tmp.next;
        }
        output += "]";
        return output;
    }
}