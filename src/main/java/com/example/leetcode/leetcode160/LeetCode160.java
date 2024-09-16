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


    /**
     * 2024年9月15日 重新做了一遍
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode temp = headA;
        ListNode virtualHeadA = new ListNode(0);
        ListNode virtualHeadB = new ListNode(0);
        virtualHeadA.next = headA;
        virtualHeadB.next = headB;
        while (temp != null) {
            lenA++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            lenB++;
            temp = temp.next;
        }
        //交换过后，a是长的，b是短的
        if(lenB > lenA){
            temp = headB;
            headB = headA;
            headA = temp;
            int temp2 = lenB;
            lenB = lenA;
            lenA =temp2;
            // 犯了一个错。下面两行在第一次提交代码的时候没有写。
            // 交换完链表A跟链表B后，相应的虚拟头节点也要做修改
            virtualHeadA.next = headA;
            virtualHeadB.next = headB;
        }
        int count = lenA-lenB;
        ListNode curA = virtualHeadA;
        for(int i = 0; i < count;i++){
            curA = curA.next;
        }
        //此时链表a跟链表b的剩余个数是一样的
        ListNode curB = virtualHeadB;
        while(curA != null && curB != null){
            if(curA == curB){
                return curA;
            }else{
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}
