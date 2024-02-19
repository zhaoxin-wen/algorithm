package com.example.leetcode.leetcode209;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author wzw
 * @date 2024/1/20 13:41
 * @description
 */
public class LeetCode209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * <p>
     * 示例：
     * <p>
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 提示：
     * <p>
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     *
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws JsonProcessingException {


    }
    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null) {
            return 0;
        }
        int left = 0, right = 0;
        int curSum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            curSum += nums[right];
            /**
             * 犯错点一：下面这里应该用while，而不是if
             */
            while (curSum >= target) {
                result = Math.min(result, right - left + 1);
                curSum -= nums[left++];
            }
            right++;
        }
        //犯错点二：假如代码不进入循环，那么应该按照题目要求应该返回0，而不是Integer.MAX_VALUE
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
