package com.example.leetcode.leetcode19;

import com.example.leetcode.leetcode203.ListNode;

import java.util.List;

/**
 * @author wzw
 * @date 2024/2/20 22:56
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LeetCode19 {

    public static void main(String[] args) {

    }

    /**
     * 分类讨论
     * 情况1，删除这个节点后，链表为空
     * 情况2，删除这个节点后，链表不为空
     *
     * 可以用快慢指针，slow在fast的前n位，当fast为null时，slow指的就是倒数第n个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //先考虑正常情况，再考虑特殊情况
        ListNode dumyNode = new ListNode();
        dumyNode.next = head;
        ListNode slow = dumyNode;
        ListNode fast = slow;
        for (int i = n; i > 0; i--) {
            if(fast.next != null){
                fast = fast.next;
            }
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        /**
         * 特别注意
         * 第一次写的时候写成了返回head
         * 第二次写的时候写成了返回slow.next
         * 均不对，自己想一下为什么不行。
         */
        return dumyNode.next;
    }
}
