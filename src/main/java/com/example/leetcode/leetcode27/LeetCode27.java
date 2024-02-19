package com.example.leetcode.leetcode27;

/**
 * @author wzw
 * @date 2024/1/16 23:23
 * @description
 */
public class LeetCode27 {
    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 3, 0, 4, 2};
//        int resultLength = removeElement(nums, 2);
//        System.out.println("resultLength = " + resultLength);
//        int resultLength = removeElement1(nums, 2);
//        System.out.println("resultLength = " + resultLength);

        int resultLength = removeElement2(nums, 2);
        System.out.println("resultLength = " + resultLength);
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                length--;
            }

        }
        return length;
    }

    public static int removeElement1(int[] nums, int val) {
        /**
         * 特殊情况
         *  1:第一个元素是要被移除的元素
         *  2:最后一个元素是要被移除的元素
         *  3:数组全部元素都是要移除的元素
         *  4:数组全部元素都不是要移除的元素
         *  5:空数组 返回0
         * 步骤
         *  while（fast<size){
         *  当fast指向的元素不是要被移除的元素时，把fast指向的元素赋值给slow指向的元素，并且fast和slow同时向后移动；
         *  当fast指向的元素是要被移除的元素时，fast向后移动，slow不动。
         *  }
         *
         */
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int size = nums.length;
        while (fast < size) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }


    public static int removeElement2(int[] nums, int val) {
        /**
         * 特殊情况
         *  1:第一个元素是要被移除的元素
         *  2:最后一个元素是要被移除的元素
         *  3:数组全部元素都是要移除的元素
         *  4:数组全部元素都不是要移除的元素
         *  5:空数组 返回0
         * 步骤
         *  whiel(left < right){
         *      while(){
         *      从左边找到第需要被替换的元素
         *      }
         *      while(){
         *      从右边找到不需要被替换的元素
         *      }
         *      把右边找到的元素赋值给左边。
         *  }
         * 当循环结束时，left指向的新数组的右边。此时left的位置等于新数组的长度。
         */
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            while (left <= right && nums[left] != val) {
                left++;
            }
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                //当把右边的值赋给左边后，就不需要再考虑这两个位置的元素了，所以要执行下边两行代码
                left++;
                right--;
            }
        }
        return left;
    }


}
