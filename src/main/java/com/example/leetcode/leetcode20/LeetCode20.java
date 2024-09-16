package com.example.leetcode.leetcode20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzw
 * @date 2024/3/21 21:37
 * @description
 */
public class LeetCode20 {
    public static void main(String[] args) {

    }

    /**
     * 分类讨论
     * 第一种情况： (()  左边括号多余
     * 第二种情况： (]   括号不匹配
     * 第三种情况： ())  右边括号不匹配
     * 第四种情况： ()   括号正确匹配
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '[') {
                deque.push(']');
            } else if (ch == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || deque.peek() != ch) {//deque.isEmpty()对应第三种情况;deque.peek() != ch对应第二种情况
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty(); // 第一种情况，这里返回false;第四种情况，这里返回true;
    }
}
