package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-28
 */
public class Leet34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int i = 0, j = nums.length - 1;

        // find left most
        boolean found = false;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) {
                j = m - 1;
                found = true;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }

        if (!found) {
            return new int[]{-1, -1};
        }

        int[] res = new int[2];
        // the left most position is i
        res[0] = i;

        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }

        // the right most position is j
        res[1] = j;

        return res;
    }
}
