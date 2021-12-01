package com.leetcode.structure.d07;

import java.util.HashMap;

/**
 * 判断链表中是否有环
 *
 * @author Kar
 * @create 2021-11-26 上午8:52
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Object> map = new HashMap<>();
        while (temp != null){
            if(map.containsKey(temp)) {
                return true;
            }
            map.put(temp, null);
            temp = temp.next;
        }
        return false;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
