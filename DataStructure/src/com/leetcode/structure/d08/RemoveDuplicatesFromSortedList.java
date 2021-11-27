package com.leetcode.structure.d08;

import com.leetcode.structure.d07.bean.ListNode;

/**
 * 2、删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * @author kar
 * @create 2021-11-27 14:25
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
        System.out.println(list.deleteDuplicates(new ListNode(1
                , new ListNode(2
                , new ListNode(2
                , new ListNode(4
                , new ListNode(4
                , new ListNode(6
                , new ListNode(7)))))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }
}
