package com.example.leetcode.leetcode344;

/**
 * @author wzw
 * @date 2024/10/3 23:06
 * @description

 */
public class LeetCode344 {
    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char temp;
        while(left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
