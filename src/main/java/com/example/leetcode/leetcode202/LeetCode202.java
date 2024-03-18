package com.example.leetcode.leetcode202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wzw
 * @date 2024/3/10 20:38
 * @description 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class LeetCode202 {
    public static void main(String[] args) {
        boolean isHappy = isHappy(4);
    }

    /**
     * 1.放n入set
     * 2.计算n的位数的平方
     * 3.判断set是否包含
     *
     * @param n
     * @return
     */
//    public static boolean isHappy(int n) {
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(n);
//        int result = cal(n);
//        if(result == 1){
//            return true;
//        }
//        if (set.contains(result)) {
//            return false;
//        }
//        while (!set.contains(result)) {
//            set.add(result);
//
//            result = cal(result);
//            if(result == 1){
//                return true;
//            }
//            if (set.contains(result)) {
//                return false;
//            }
//        }
//        return false;
//    }

    /**
     * chatgpt的写法
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = cal(slow);
            fast = cal(cal(fast));
        } while (slow != fast);

        return slow == 1;
    }



    /**
     * 计算n的各个位数的平方和
     * @param n 要计算的数
     * @return 各个位数的平方和
     */
    public static int cal(int n) {
        int temp, result = 0;
        while (n != 0) {
            temp = n % 10;
            n = n / 10;
            result += temp * temp;
        }
        return result;
    }

    /**
     * 代码随想录的写法
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }



}
