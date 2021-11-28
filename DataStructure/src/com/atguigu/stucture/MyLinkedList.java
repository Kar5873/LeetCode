package com.atguigu.stucture;

/**
 * @author kar
 * @create 2021-11-28 18:22
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new Node("1号", 1));
        list.add(new Node("2号", 2));
        list.add(new Node("3号", 3));
        list.add(new Node("4号", 4));
        // list.update(new Node("2000号", 2));
        // list.del(1);
        list.list();
        System.out.println();
        MyLinkedList list1 = new MyLinkedList();
        list1.addOrder(new Node("一号", 1));
        list1.addOrder(new Node("四号", 4));
        list1.addOrder(new Node("三号", 3));
        list1.addOrder(new Node("二号", 2));
        // list1.reverseList1();
        list1.list();
        // list1.printReverse();
        System.out.println();
        // mergeSortedList(list1, list).list();
        mergeSortedList1(list1, list).list();
    }

    private Node head = new Node("", 0);


    /**
     * 迭代
     *
     * @param list1
     * @param list2
     * @return
     */
    public static MyLinkedList mergeSortedList(MyLinkedList list1, MyLinkedList list2) {
        Node cur1 = list1.head.next;
        Node cur2 = list2.head.next;
        MyLinkedList list = new MyLinkedList();
        Node tmp = list.head;
        while (cur1 != null && cur2 != null) {
            if ((cur1.no < cur2.no)) {
                tmp.next = cur1;
                cur1 = cur1.next;
            } else {
                tmp.next = cur2;
                cur2 = cur2.next;
            }
            tmp = tmp.next;
        }
        if (cur1 == null) {
            tmp.next = cur2;
        } else {
            tmp.next = cur1;
        }
        return list;
    }

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public static MyLinkedList mergeSortedList1(MyLinkedList list1, MyLinkedList list2) {
        MyLinkedList list = new MyLinkedList();
        list.head.next = list.recursionBiggestNode(list1.head.next,list2.head.next);
        return list;
    }

    private Node recursionBiggestNode(Node node1,Node node2){
        if (node1 == null) {
            return node2;
        }else if (node2 == null) {
            return node1;
        }else if (node1.no < node2.no){
            node1.next = recursionBiggestNode(node1.next,node2);
            return node1;
        }else {
            node2.next = recursionBiggestNode(node1,node2.next);
            return node2;
        }
    }

    public void printReverse() {
        if (head.next == null) {
            return;
        }
        System.out.println(reversePrint(head.next).no);
    }

    private Node reversePrint(Node cur) {
        if (cur.next != null) {
            Node reverse = reversePrint(cur.next);
            System.out.println(reverse.no);
        }
        return cur;

    }


    /**
     * 迭代：正向遍历翻转
     * 步骤：
     * 1、保存下一个节点
     * 2、调转cur的next，使cur称为新链表的头
     * 3、另存cur（即新链表）
     * 4、cur赋为下一个节点，重复1-4，直到null
     */
    public void reverseList() {
        Node cur = head.next;
        Node pre = null; // 新链表
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre; // 插在新链表的头部，cur就成了新链表
            pre = cur;
            cur = tmp;
        }
        head.next = pre;
    }

    /**
     * 递归：逆向遍历翻转
     * 步骤
     * 1、递归获取原链表尾，返回新链表头
     * 2、递归返回时，cur为原链表尾的倒数下一个节点
     * 3、cur.next.next为原链表尾的指向，调转它
     * 4、断开原来指向链表尾的箭头。
     * 5、返回新链表头。
     */
    public void reverseList1() {
        Node cur = head.next;
        head.next = reverse(cur);
    }

    private Node reverse(Node cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        // 递归返回时，reverse为新的链表头
        Node reverse = reverse(cur.next);
        // 翻转新箭头
        cur.next.next = cur;
        cur.next = null;
        // 返回新链表
        return reverse;
    }

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