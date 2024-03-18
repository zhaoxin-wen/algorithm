package com.example.leetcode.leetcode142;

import com.example.leetcode.leetcode203.ListNode;

/**
 * @author wzw
 * @date 2024/2/21 20:39
 * @description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 前提条件：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class LeetCode142 {
    public static void main(String[] args) {

    }

    /**
     * 因为链表的长度可能是0，所以我们这里需要分类讨论
     * 1、当链表的长度为0时
     * 2、链表的长度不为0
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //情况1，head为null
        if (head == null) {
            return null;
        }
        //情况2，head不为null
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
