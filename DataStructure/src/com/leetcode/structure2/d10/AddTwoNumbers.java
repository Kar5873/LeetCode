package com.leetcode.structure2.d10;

import com.leetcode.structure.d07.bean.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 难度中等
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author Kar
 * @create 2021-12-14 上午11:42
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(0), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode ans = l1;
        while (l1 != null && l2 != null) {
            add += l1.val + l2.val;
            l1.val = add % 10;
            add /= 10;
            if (l1.next == null || l2.next == null) {
                if (l1.next == null) {
                    l1.next = l2.next;
                }
                while (add > 0) {
                    l1.next = l1.next != null ? l1.next : new ListNode();
                    l1 = l1.next;
                    add += l1.val;
                    l1.val = add % 10;
                    add /= 10;
                }
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return ans;
    }
}
