package com.example.leetcode.leetcode242;

/**
 * @author wzw
 * @date 2024/2/22 0:30
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * 说明: 你可以假设字符串只包含小写字母。
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class LeetCode242 {
    public static void main(String[] args) {

    }

    /**
     * 已知这两个字符串肯定不为空
     * 那么首先判断这两个字符串的长度
     * 1、两个字符串的长度不相等，直接返回false
     * 2、字符串相等，则还需进一步的分析
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char c;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            arr[c - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            arr[c - 'a'] -= 1;
        }
        for (int i : arr) {
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
