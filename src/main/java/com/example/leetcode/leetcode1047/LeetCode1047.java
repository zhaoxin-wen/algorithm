package com.example.leetcode.leetcode1047;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzw
 * @date 2024/3/21 22:04
 * @description
 */
public class LeetCode1047 {
    public static void main(String[] args) {
        String s = removeDuplicates2("abbaca");
        System.out.println(s);
    }

    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else if (deque.peek() == ch) {
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }


    public static String removeDuplicates2(String s) {
        char[] charArr = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (deque.isEmpty() || deque.peek() != charArr[i]) {
                deque.push(charArr[i]);
            } else if (s.charAt(i) == deque.peek()) {
                deque.pop();
            }
        }
        Deque<Character> deque2 = new LinkedList<>();
        while (!deque.isEmpty()) {
            deque2.push(deque.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!deque2.isEmpty()) {
            sb.append(deque2.pop());
        }
        return String.valueOf(sb);
    }



}
