package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            // left asc
            if (nums[i] < nums[mid]) {
                if (nums[i] == target) {
                    return i;
                } else if (target > nums[i] && target < nums[mid]) {
                    i++;
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else { // right asc

                if (nums[j] == target) {
                    return j;
                } else if (target > nums[mid] && target < nums[j]) {
                    i = mid + 1;
                    j--;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }
}
