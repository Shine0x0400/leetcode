package com.zjl.leetcode;

import java.util.Arrays;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int ceil = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    ceil = Math.min(ceil, sum);
                    hi--;
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                } else {
                    floor = Math.max(floor, sum);
                    lo++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                }
            }
        }

        if (ceil == Integer.MAX_VALUE) {
            return floor;
        }

        if (floor == Integer.MIN_VALUE) {
            return ceil;
        }

        int above = ceil - target;
        int below = target - floor;
        return above < below ? ceil : floor;
    }
}
