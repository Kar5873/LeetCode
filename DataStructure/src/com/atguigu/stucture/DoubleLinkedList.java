package com.atguigu.stucture;

/**
 * @author kar
 * @create 2021-11-28 23:28
 */
public class DoubleLinkedList {
    private Node head;
    public DoubleLinkedList(int[] list){
        for (int i = 0; i < list.length; i++) {
        }
    }
    class Node{
        private int val;
        private Node pre;
        private Node next;
        public Node(){}
        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
