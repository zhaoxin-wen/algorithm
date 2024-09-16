package com.example.leetcode.leetcode225;

import com.example.leetcode.leetcode15.LeetCode15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wzw
 * @date 2024/3/21 0:02
 * @description
 */
public class LeetCode225 {


    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public static void main(String[] args) {

    }

    public LeetCode225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
