package com.zjl.leetcode;

import org.junit.Test;

/**
 * @author zjl
 * @date 2019-07-14
 */
public class Leet152_MaximumProductSubarray {
    @Test
    public void test() {
        int max = maxProduct(new int[]{2, 3, -2, -1, 0, 4});
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];

        // 计算以i结尾的子数组的最大和最小乘积
        for (int i = 1, maxi = max, mini = max; i < nums.length; i++) {
            // 以i结尾的最大乘积，根据有无i-1参与得出
            int minResult = mini * nums[i];
            int maxResult = maxi * nums[i];

            if (nums[i] < 0) {
                maxi = Math.max(nums[i], minResult);
                mini = Math.min(nums[i], maxResult);
            } else {
                maxi = Math.max(nums[i], maxResult);
                mini = Math.min(nums[i], minResult);
            }

            max = Math.max(max, maxi);
        }

        return max;
    }

//    // 动态规划
//    fun maxProduct(nums: IntArray): Int {
//        var m = Int.MIN_VALUE
//        for (i in nums.indices) {
//            m = kotlin.math.max(m, nums[i])
//            for (j in i + 1 until nums.size) {
//                nums[i] *= nums[j]
//                m = kotlin.math.max(m, nums[i])
//            }
//        }
//
//        return m
//    }

//    // brute force
//    public int maxProduct(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int max = nums[0];
//
//        // 计算[i, j] product
//        for (int i = 0; i < nums.length; i++) {
//            int maxi = 1;
//
//            for (int j = i; j < nums.length; j++) {
//                maxi *= nums[j];
//                max = Math.max(max, maxi);
//            }
//
//        }
//
//        return max;
//    }
}
