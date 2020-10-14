package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int remain = 0 - nums[i];

            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                int sum = nums[l] + nums[r];

                if (sum == remain) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    result.add(triplet);

                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);

                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else if (sum > remain) {
                    r--;
                } else {
                    l++;
                }
            }

        }

        return result;
    }

//    //Time Limit Exceeded
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums.length < 3) {
//            return result;
//        }
//
//        // sort first
//        quickSort(nums, 0, nums.length - 1);
//
//        return threeSumInternal(nums, 0, 3, 0);
//
//    }
//
//    private void quickSort(int[] nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//
//        int i = start;
//        int j = end;
//        int sentry = nums[i];
//
//        while (i < j) {
//            while (i < j && nums[j] >= sentry) {
//                j--;
//            }
//
//            if (i < j) {
//                nums[i++] = nums[j];
//            }
//
//            while (i < j && nums[i] <= sentry) {
//                i++;
//            }
//
//            if (i < j) {
//                nums[j--] = nums[i];
//            }
//        }
//        nums[i] = sentry;
//
//        quickSort(nums, start, i - 1);
//        quickSort(nums, i + 1, end);
//    }
//
//    private List<List<Integer>> threeSumInternal(int[] nums, int start, int count, int sum) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (count == 1) {
//            for (int i = start; i < nums.length; i++) {
//                if (nums[i] == sum) {
//                    ArrayList<Integer> one = new ArrayList<>();
//                    one.add(sum);
//                    result.add(one);
//                    return result;
//                }
//            }
//
//            return result;
//        }
//
//        for (int i = start; i <= nums.length - count; ) {
//            int num = nums[i];
//            for (List<Integer> list :
//                    threeSumInternal(nums, i + 1, count - 1, sum - num)) {
//
//                list.add(num);
//                result.add(list);
//            }
//
//            i++;
//            while (i <= nums.length - count && nums[i] == num) {
//                i++;
//            }
//
//        }
//
//        return result;
//    }
}
