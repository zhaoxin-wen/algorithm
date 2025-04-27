package com.example.leetcode.leetcode239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzw
 * @date 2024/10/5 16:18
 * @description

 */
public class LeetCode239 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, -3, 1, -4, 2, -7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==  1){
            return nums;
        }

        int[] resultInts = new int[nums.length-k+1];
        int num = 0;

        myQueue myQueue = new myQueue();

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        resultInts[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
                myQueue.poll(nums[i-k]);
                myQueue.add(nums[i]);
                resultInts[num++] = myQueue.peek();
            

        }

        return resultInts;

    }


}


class myQueue {

    Deque<Integer> deque = new LinkedList<>();


    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }

}
