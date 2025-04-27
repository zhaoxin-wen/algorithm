package com.example.leetcode.sortalgorithm.quicksort;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

/**
 * @author wzw
 * @date 2025/4/17 23:42
 * @description

 */
public class QuickSort2 {
    public static void main(String[] args) throws JsonProcessingException {
        int[] arr = new int[]{4, 3,1, 5, 7};
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 选择基准并分区
        int pivot = partition(arr, left, right);

        // 递归排序左右子数组
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    // 分区函数（核心逻辑）
    private static int partition(int[] arr, int left, int right) {
        // 选择中间元素作为基准（可优化为三数取中法）
        int pivotValue = arr[(left + right) / 2];
        int i = left, j = right;

        while (i <= j) {
            // 找到左边第一个 ≥ pivot 的元素
            while (arr[i] < pivotValue) i++;
            // 找到右边第一个 ≤ pivot 的元素
            while (arr[j] > pivotValue) j--;

            // 交换元素并移动指针
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i; // 返回分界点
    }

    // 交换数组中两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
