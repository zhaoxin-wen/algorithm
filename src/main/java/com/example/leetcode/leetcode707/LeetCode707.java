package com.example.leetcode.leetcode707;


import com.example.leetcode.leetcode203.ListNode;

/**
 * @author wzw
 * @date 2024/2/5 0:43
 * @description
 */
public class LeetCode707 {

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param args
     */

    int size;

    ListNode head;


    public LeetCode707() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public static void main(String[] args) {

    }

    public void MyLinkedList() {


    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        ListNode dummy = head;
        ListNode newNode = new ListNode(val);
        newNode.next = dummy.next.next;
        if (index <= 0) {
            dummy.next = newNode;
        } else if (index >= size) {
            for (int i = 0; i < size; i++) {
                dummy = dummy.next;
            }
            dummy.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode dummy = head;

    }

}
