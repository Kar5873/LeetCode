package com.leetcode.structure2.d10;

import com.leetcode.structure.d07.bean.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 142. 环形链表 II
 * <p>
 * 难度中等
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * @author Kar
 * @create 2021-12-14 下午3:16
 */
public class LinkedListCycleII {
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                // 从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
                // 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 tmp。
                // 起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
                ListNode tmp = head;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return tmp;
            }
        }
        return null;
    }

    // 哈希表
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            set.add(tmp);
            tmp = tmp.next;
        }
        return null;
    }
}
