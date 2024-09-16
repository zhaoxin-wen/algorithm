package com.example.leetcode.leetcode232;

import java.util.Stack;

/**
 * @author wzw
 * @date 2024/3/20 23:47
 * @description
 */
public class LeetCode232 {


    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public static void main(String[] args) {
        /**
         * 我刚开始的时候我忘了怎么创建栈
         */
    }

    public LeetCode232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public void dumpstackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
