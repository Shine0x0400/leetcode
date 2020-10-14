package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-19
 */
public class Leet53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];

        // the max of subArray ends in i, 以i结尾的子串的最大值
        int maxEndI = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndI = Math.max(maxEndI + nums[i], nums[i]);
            max = Math.max(max, maxEndI);
        }

        return max;
    }

//    // DP
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            int sumi = nums[i];
//            max = Math.max(max, sumi);
//            for (int j = i + 1; j < nums.length; j++) {
//                sumi += nums[j];
//                max = Math.max(max, sumi);
//            }
//        }
//
//        return max;
//    }


//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            if (sum > max) {
//                max = sum;
//            }
//
//            if (sum <= 0) {
//                continue;
//            }
//
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//
//                if (sum <= 0) {
//                    break;
//                }
//            }
//        }
//
//        return max;
//    }
}
