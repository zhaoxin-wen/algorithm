package com.example.leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzw
 * @date 2024/3/17 22:00
 * @description
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 *
 * 本题其实有四个重点：
 *
 * 1、为什么会想到用哈希表
 * 2、哈希表为什么用map
 * 3、本题map是用来存什么的
 * 4、map中的key和value用来存什么的
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 我的初版。
     * 定义result[]跟cursor这两行很不好看
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Object, Object> hashMap = new HashMap<>();
        int cursor = 0;
        while (cursor < nums.length && !hashMap.containsKey(target-nums[cursor])){
            hashMap.put(nums[cursor],cursor);
            cursor++;
        }
        result[0] = cursor;
        Integer temp  = target-nums[cursor];
        result[1] = (int)hashMap.get(temp);
        return  result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i]; // 遍历当前元素，并在map中寻找是否有匹配的key
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i); // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
