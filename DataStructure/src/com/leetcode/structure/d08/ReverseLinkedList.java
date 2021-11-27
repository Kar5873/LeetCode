package com.leetcode.structure.d08;

import com.leetcode.structure.d07.RemoveLinkedListElements;
import com.leetcode.structure.d07.bean.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author kar
 * @create 2021-11-27 11:30
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList elements = new ReverseLinkedList();
        System.out.println(elements.reverseList(new ListNode(1
                , new ListNode(2
                , new ListNode(3
                , new ListNode(4
                , new ListNode(5
                , new ListNode(6
                , new ListNode(7)))))))));
    }
    /**
     * 迭代
     *
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            // 保存原链表的下一个节点的地址
            ListNode next = cur.next;
            // 修改cur的next指向，此时cur成了新的链表。
            cur.next = pre;
            // 将新的链表cur交给pre保存
            pre = cur;
            // 找回原链表的地址继续操作，直到原链表尾
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     * 过程：
     *  1）原链表
     *  1 -> 2 -> 3
     *  2）递归获取链表尾，翻转箭头，返回以原链表尾为首的新链表
     *  1 -> 2 <- 3
     *  3）每轮递归返回继续翻转原链表的箭头，然后依旧是返回新链表。
     *  1 <- 2 <- 3
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先递归获取原链表尾，作为新链表
        ListNode newHead = reverseList1(head.next);
        // 由于上面的递归，此时最先翻转的是链表尾，建立新的next箭头
        head.next.next = head;
        // 删除原链表的next箭头
        head.next = null;
        // 返回新链表
        return newHead;
    }
}
