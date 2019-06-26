package com.zjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {

                        lists.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));

                        lo++;
                        hi--;
                        while (lo < hi && nums[lo] == nums[lo - 1]) {
                            lo++;
                        }

                        while (lo < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                    } else if (sum > target) {
                        hi--;
                        while (lo < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                    } else {
                        lo++;
                        while (lo < hi && nums[lo] == nums[lo - 1]) {
                            lo++;
                        }
                    }
                }
            }
        }

        return lists;
    }
}
