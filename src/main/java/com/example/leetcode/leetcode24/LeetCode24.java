package com.example.leetcode.leetcode24;

import com.example.leetcode.leetcode203.ListNode;

/**
 * @author wzw
 * @date 2024/2/20 22:21
 * @description
 */
public class LeetCode24 {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {


        /**
         * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
         * 链表中节点的数目在范围 [0, 100] 内
         * 0<=Node.val<=100
         *
         * 分三种情况讨论
         * 1.链表的长度为0
         * 2.链表的长度为单数
         * 3.链表的长度为双数且不为零
         */
        //当链表的长度为0时
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        int temp = cur.val;
        while (cur != null && next != null) {
            temp = cur.val;
            cur.val = next.val;
            next.val = temp;
            cur = next.next;
            if (next.next != null) {
                next = next.next.next;
            }
        }
        return head;

    }
}
