package com.leetcode.structure.d09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现FIFO队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * @author kar
 * @create 2021-11-28 16:59
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        // Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        int param_5 = obj.pop();
        boolean param_6 = obj.empty();
    }

    static class MyQueue {
        private Deque<Integer> popStack;
        private Deque<Integer> pushStack;

        public MyQueue() {
            popStack = new LinkedList<>();
            pushStack = new LinkedList<>();
        }
        private void turn(Deque<Integer> from,Deque<Integer> to){
            if (to.isEmpty()) {
                while (!from.isEmpty()) {
                    to.push(from.pop());
                }
            }
        }
        public void push(int x) {
            turn(popStack,pushStack);
            pushStack.push(x);
        }

        public int pop() {
            turn(pushStack,popStack);
            return popStack.isEmpty() ? 0 : popStack.pop();
        }

        public int peek() {
            turn(pushStack,popStack);
            return popStack.isEmpty() ? 0 : popStack.peek();
        }

        public boolean empty() {
            return popStack.isEmpty() && pushStack.isEmpty();
        }
    }


    static class MyQueue1 {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue1() {
            inStack = new LinkedList<Integer>();
            outStack = new LinkedList<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        /**
         * 这里实现只有在outStack为空时才将inStack的数据装入outStack
         * 比前一个实现少了不必要的转移步骤
         * @return
         */
        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
