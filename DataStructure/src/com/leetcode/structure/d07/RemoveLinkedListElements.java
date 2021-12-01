package com.leetcode.structure.d07;

import com.leetcode.structure.d07.bean.ListNode;

/**
 * 移除链表中的元素
 *
 * @author kar
 * @create 2021-11-26 22:49
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements elements = new RemoveLinkedListElements();
        System.out.println(elements.removeElements(new ListNode(6
                , new ListNode(6
                , new ListNode(6
                , new ListNode(6
                , new ListNode(6
                , new ListNode(6
                , new ListNode(6))))))), 6));
    }

    /**
     * 迭代
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0, head);
        ListNode res = tmp;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return res.next;
    }


    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }


}
