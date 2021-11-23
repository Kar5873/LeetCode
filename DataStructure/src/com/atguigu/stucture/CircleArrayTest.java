package com.atguigu.stucture;

import java.util.Scanner;

/**
 * @author kar
 * @create 2021-11-21 10:00
 */
public class CircleArrayTest {
    public static void main(String[] args) {
        System.out.println("输入队列长度：");
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        CircleArray circleArray = new CircleArray(scanner.nextInt());
        for (; ; ) {
            System.out.println("s - 显示队列");
            System.out.println("e - 退出菜单");
            System.out.println("a - 添加元素");
            System.out.println("p - 取出元素");
            System.out.println("h - 查看头元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'e':
                    return;
                case 'a':
                    System.out.println("请输入新元素：");
                    try {
                        circleArray.push(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println("请输入数字");
                    }
                    break;
                case 'p':
                    try {
                        System.out.println("取出元素:" + circleArray.pop());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("头元素:" + circleArray.head());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}

class CircleArray {
    private int maxSize = 0;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public CircleArray(int size) {
        this.maxSize = size + 1;
        arr = new int[maxSize];
        // System.out.println(arr.length);
    }

    public boolean isFull() {
        //尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定(!!!)
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int add) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        arr[rear] = add;
        rear = (rear + 1) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        try {
            return arr[front];
        } finally {
            front = (front + 1) % maxSize;
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("Queue value:");
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        return arr[front];
    }
}
