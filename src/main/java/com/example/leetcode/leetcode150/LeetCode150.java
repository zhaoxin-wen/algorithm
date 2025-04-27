package com.example.leetcode.leetcode150;


import java.util.*;

/**
 * @author wzw
 * @date 2024/3/21 22:40
 * @description
 */
public class LeetCode150 {
    public static void main(String[] args) {
        String[] token = new String[]{"4","13","5","/","+"};
        int i = evalRPN(token);
        System.out.println(i);
    }

    /**
     * 需要注意的是，减法时，弹出的第一个数是减数，弹出的第二数是被减数，如`ba-`，遇到`-`，接下来弹出`a`，然后`a`前面接上`-`，然后弹出`b`，形成表达式`b-a`。
     * 乘法时，弹出的第一个数是除数，弹出的第二个数是被除数，如`ba/`，遇到`/`，接下来弹出`a`，然后`a`前面接上`/`，然后弹出`b`，形成表达式`b/a`。
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}


