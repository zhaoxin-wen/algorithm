package com.example.leetcode.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wzw
 * @date 2024/3/20 19:32
 * @description
 */
public class LeetCode18 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            /**
             * 刚开始把i的剪枝跟去重 写到了j层里。而且代码也不对
             */
            if (nums[i] > 0 && nums[i] > target) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 刚开始我写的是   if (j >  1 && nums[j] == nums[j - 1])
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return lists;
    }


    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if ((nums[j] + nums[i]) > target && (nums[j] + nums[i] >= 0)) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

}
