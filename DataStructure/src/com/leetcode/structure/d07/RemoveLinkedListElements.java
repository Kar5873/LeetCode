package com.leetcode.structure.d07;

import com.leetcode.structure.d07.bean.ListNode;

/**
 * @author kar
 * @create 2021-11-26 22:49
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements elements = new RemoveLinkedListElements();
        System.out.println(elements.removeElements(new ListNode(1
                , new ListNode(2
                , new ListNode(6
                , new ListNode(3
                , new ListNode(4
                , new ListNode(5
                , new ListNode(6))))))), 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0, head);
        ListNode res = tmp;
        while (head != null) {
            if ( head.val == val){
                tmp.next = tmp.next.next;
                //head = head.next;
            }
            head = head.next;
            tmp = tmp.next;
        }
        return res.next;
    }
}
