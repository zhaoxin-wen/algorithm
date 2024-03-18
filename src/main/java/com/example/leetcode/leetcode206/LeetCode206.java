package com.example.leetcode.leetcode206;

import com.example.leetcode.leetcode203.ListNode;

/**
 * @author wzw
 * @date 2024/2/19 22:57
 * @description
 */
public class LeetCode206 {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
