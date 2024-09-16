package com.example.leetcode.leetcode704;

import java.util.Objects;

/**
 * @author wzw
 * @date 2024/1/16 22:18
 * @description
 */
public class LeetCode704 {


    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
     */
/*    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5};
//        int[] array = new int[]{};
        int target = 5;
//        int result = LeetCode704.search(array, target);
        int result = LeetCode704.search1(array, target);
        System.out.println("result = " + result);
    }*/
    public static int search(int[] nums, int target) {
        int subscripted = -1;
        if (nums == null || nums.length == 0) {
            return subscripted;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                subscripted = i;
                break;
            }
        }
        return subscripted;
    }


    public static int searchTargetNum(int[] nums, int target) {
        int subscripted = -1;
        //当nums数组不存在或者长度为0时，返回-1
        if (nums == null || nums.length == 0) {
            return subscripted;
        }
        //待比较数小于数组的第一个数或者大于最后一个数时，则target肯定不在数组里，因为nums是有序的。
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //利用数组有序的特点，可以用二分查找法
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                subscripted = middle;
                return subscripted;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return subscripted;
    }


    /**
     * 二次复习
     * @date 2024/9/11 20:08
     */

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = searchTarget(arr, target);
        System.out.println(result);
    }


    public static int searchTarget(int[] arr, int target) {
        int result = -1;

        if (arr == null || arr.length == 0) {
            return result;
        } else if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            } else {
                return result;
            }
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {

            int middle = (left + right) / 2;
            if (arr[middle] < target) {
                left = middle + 1;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return result;
    }
}