package com.example.leetcode.leetcode977;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wzw
 * @date 2024/1/20 13:41
 * @description
 */
public class LeetCode977 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按非递减顺序 排序。
     * 示例 1：
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     * @param args
     */
    public static void main(String[] args) throws JsonProcessingException {

         /**
         * 思路：
         * 如果直接让每个数变成自己的平方，并存在原本的位置。那么数据并不是有序的，此时还要调用一次
         */
        int[] nums = new int[]{1};
        int[] result = sortedSquares(nums);
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        // 将数组转换为JSON字符串
        String json = objectMapper.writeValueAsString(result);
        System.out.println(json);
    }

    public static int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        int cursor = right;
        int newNums[] = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                newNums[cursor--] = nums[right] * nums[right];
                right--;
            } else if (nums[left] * nums[left] > nums[right] * nums[right]) {
                newNums[cursor--] = nums[left] * nums[left];
                left++;
            }
        }
        return newNums;
    }

}
