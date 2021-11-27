package com.atguigu.stucture;

/**
 * @author kar
 * @create 2021-11-23 23:05
 */
public class ReverseList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new Node("一号", 1));
        list.add(new Node("二号", 2));
        list.add(new Node("三号", 3));
        list.add(new Node("四号", 4));
        list.update(new Node("2000号", 2));
        list.del(1);
        list.list();
        MyLinkedList list1 = new MyLinkedList();
        list1.addOrder(new Node("一号", 1));
        list1.addOrder(new Node("四号", 4));
        list1.addOrder(new Node("三号", 3));
        list1.addOrder(new Node("二号", 2));
        list1.list();
    }


}

class MyLinkedList {
    private Node head = new Node("", 0);

    public void add(Node newNode) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addOrder(Node newNode) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no > newNode.no) {
                break;
            } else if (temp.next.no == newNode.no) {
                System.out.println("节点已存在");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void update(Node newNode) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == newNode.no) {
                newNode.next = temp.next.next;
                temp.next = newNode;
            }
            temp = temp.next;
        }
    }

    public void del(int no) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void list() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.no + " : " + temp.getName());
            temp = temp.next;
        }
    }
}

class Node {
    public Node next;

    public Node(String name, int no) {
        this.name = name;
        this.no = no;
    }

    private String name;
    public int no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}