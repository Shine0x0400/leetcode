package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-16
 */
public class Leet162_FindPeakElement {

    public int findPeakElement(int[] nums) {

        int l = 0, h = nums.length - 1;

        while (l < h) {
            int m = (l + h) >> 1;
            if (nums[m] > nums[m + 1]) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
