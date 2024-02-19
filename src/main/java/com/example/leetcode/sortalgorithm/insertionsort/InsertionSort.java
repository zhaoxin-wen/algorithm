package com.example.leetcode.sortalgorithm.insertionsort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wzw
 * @date 2024/2/2 20:31
 * @description
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 5, 7};
        arr = insertionSort(arr);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(arr);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] insertionSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
