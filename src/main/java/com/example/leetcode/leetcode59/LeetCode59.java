package com.example.leetcode.leetcode59;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wzw
 * @date 2024/1/29 21:21
 * @description
 */
public class LeetCode59 {
    public static void main(String[] args) throws JsonProcessingException {
        /**
         * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
         * 示例:
         * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
         */
        int[][] result = generateMatrix(4);
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        // 将数组转换为JSON字符串
        String json = objectMapper.writeValueAsString(result);
        System.out.println(json);
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int count = 0;
        int startx = 0, starty = 0;
        int horizontal = n - 1, vertical = n - 1;
        while (count < n / 2) {
            while (starty < horizontal) {
                result[startx][starty] = num++;
                starty++;
            }
            while (startx < vertical) {
                result[startx][starty] = num++;
                startx++;
            }
            while (starty > count) {
                result[startx][starty] = num++;
                starty--;
            }
            while (startx > count) {
                result[startx][starty] = num++;
                startx--;
            }
            horizontal--;
            vertical--;
            count++;
            /**
             * 下面两行没有给i和j赋值是我的犯错点二
             * 需要设置每一圈的开始位置，不然每次从数组[0][0]位置开始转圈
             */
            startx = count;
            starty = count;
        }
        /**
         * 这里是我的犯错点一！
         * 当n是奇数的时候，需要手动给数据的中心赋值
         */
        if (n % 2 == 1) {
            result[n / 2][n / 2] = num;
        }
        return result;
    }
}
