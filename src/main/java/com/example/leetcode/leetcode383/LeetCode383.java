package com.example.leetcode.leetcode383;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzw
 * @date 2024/3/18 21:32
 * @description
 */
public class LeetCode383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aac";

        boolean result = canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    /**
     * 我的版本。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct0(String ransomNote, String magazine) {
        int[] ints = new int[26];
        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            ints[aChar - 'a']++;
        }
        char[] chars1 = ransomNote.toCharArray();
        for (char c : chars1) {
            ints[c - 'a']--;
            if (ints[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 我刚开始的时候是想用map，但是其实没什么必要。因为题目说了，这两个字符串都是小写字母，所以其实用已给数组就够了
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Object, Integer> map = new HashMap<>();

        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0)+1);
        }
        char[] chars1 = ransomNote.toCharArray();
        for (char c : chars1) {
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c) < 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 代码随想录的版本
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        // shortcut
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
