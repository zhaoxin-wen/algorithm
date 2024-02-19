package com.example.leetcode.sortalgorithm.selectionsort;

/**
 * @author wzw
 * @date 2024/1/30 23:34
 * @description
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 5, 7};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {

        int maxIndex, temp, left, right;
        right = arr.length - 1;
        for (int i = 0; i < arr.length-1; i++) {
            maxIndex = 0;
            left = 0;
            /**
             * 犯错点：
             * 特别注意是<= 无序数组里最后一个数也可能是最大的
             */
            while (left <= right) {
                if (arr[left] > arr[maxIndex]) {
                    maxIndex = left;
                    System.out.println("maxIndex="+maxIndex);
                }
                left++;
            }
            temp = arr[maxIndex];
            arr[maxIndex] = arr[right];
            arr[right] = temp;
            right--;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
