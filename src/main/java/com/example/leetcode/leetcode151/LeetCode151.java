package com.example.leetcode.leetcode151;


import java.util.regex.Pattern;

/**
 * @author wzw
 * @date 2024/10/4 11:15
 * @description

 */
public class LeetCode151 {
    public static void main(String[] args) {
        //String s ="the sky is blue";
        String s = "a good   example";
        String s1 = reverseWords1(s);
        System.out.println(s1);
    }

    public static String reverseWords1(String s) {
        String trim = s.trim();
        String[] arr = trim.split(" ", -1);
        StringBuilder sbr = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) {
                sbr.append(arr[i]);
                sbr.append(" ");
            }
        }
        return String.valueOf(sbr).trim();
    }

    public static String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        System.out.println(sb);
        return sb;

    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder sb, int start, int end) {

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        System.out.println(sb);
    }

    private static void reverseEachWord(StringBuilder sb) {

        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }

}
