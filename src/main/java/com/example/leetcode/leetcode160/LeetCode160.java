package com.example.leetcode.leetcode160;

import com.example.leetcode.leetcode203.ListNode;

/**
 * @author wzw
 * @date 2024/2/21 0:13
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 */
public class LeetCode160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 分类讨论，
         * 1、headA或者headB为null，那么结果一定为null
         * 2、head跟headB均不为null
         */
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA, curB;
        curA = headA;
        int lengthA = 0, lengthB = 0;
        while (curA != null) {
            lengthA++;
            curA = curA.next;
        }
        curB = headB;
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //我们假设A比B长，如果A比B短，则交换两个链表的位置
        if (lengthA < lengthB) {
            ListNode temp= curB; //这里交换的时候使用我们自己创建的节点，尽量别改变headA和headB的值
            curB = curA;
            curA = temp;
            int swap= lengthA;
            lengthA = lengthB;
            lengthB = swap;
        }
        //现在链表A的长度一定大于等于链表B
        int gap = lengthA - lengthB;//这个值一定为正数
        while (gap-- > 0) {//这一行之前写错了，忘记了自减；所有循环一定要记得跳出循环的条件！！！
            curA = curA.next;
        }
        //现在链表A跟链表B对齐了末尾
        while (curA != null && curB != null) {
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
