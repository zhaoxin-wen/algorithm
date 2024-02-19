package com.example.leetcode.sortalgorithm.bubblesort;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author wzw
 * @date 2024/1/30 21:49
 * @description
 */
public class BubbleSort {

    public static void main(String[] args) throws JsonProcessingException {
        int[] arr = new int[]{5,2,3,1};
        arr = bubbleSort(arr);
    }

    public static int[] bubbleSort(int[] arr) throws JsonProcessingException {

        int temp;
        for (int i = 1; i < arr.length; i++) {
            boolean breakFlag = true;
            //犯错点：里面的内容都想错了
            for(int j = 0;j < arr.length-i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    breakFlag = false;
                }
            }
            if(breakFlag){
                break;
            }
        }
        return arr;
    }
}
