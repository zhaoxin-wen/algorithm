package com.example.leetcode.sortalgorithm.quicksort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wzw
 * @date 2024/2/2 21:10
 * @description
 */
public class QuickSort {
    public static void main(String[] args) throws JsonProcessingException {
        int[] arr = new int[]{4, 3,1, 5, 7};
        quickSort(arr, 0, 4);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(arr);
        System.out.println(json);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, base = arr[low];
        while (i < j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            swap(arr, i, j);
        }

        swap(arr, low, j);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("low = " + low);
        System.out.println("high = " + high);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
