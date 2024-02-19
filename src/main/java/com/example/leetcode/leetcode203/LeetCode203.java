package com.example.leetcode.leetcode203;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author wzw
 * @date 2024/2/5 0:05
 * @description
 */
public class LeetCode203 {

    /**
     * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     * 示例 2： 输入：head = [], val = 1 输出：[]
     * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
     *
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws JsonProcessingException {
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        listNode1 = removeElements(listNode1, 7);
        ListNode listNode = new ListNode();
        listNode = listNode1;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeElements(ListNode listNode, int val) {
        ListNode head = new ListNode();
        head.next = listNode;
        head = removeElements2(head, val);
        return head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
//        while (cur.next != null) {
            /**
             *  刚开始的时候写成了这样。
             *  if (cur.next.val == val) {
             *  cur.next = cur.next.next;
             *  }
             *  cur = cur.next;
             */
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head.next;
    }

}
