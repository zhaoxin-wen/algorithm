package com.example.leetcode.sortalgorithm.topk;

import java.util.Arrays;

/**
 * @author wzw
 * @date 2025/4/19 11:38
 * @description

 */
public class TopKBySorting {
    public static int[] topK(int[] arr, int k) {
        Arrays.sort(arr);
        for(int i:arr){
            System.out.println(i);
        }
        int n = arr.length;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[n - k + i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3;
        int[] topK = topK(arr, k);
        for (int num : topK) {
            System.out.print(num + " ");
        }
    }
}
