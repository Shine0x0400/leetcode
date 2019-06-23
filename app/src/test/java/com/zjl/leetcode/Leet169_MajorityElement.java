package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-23
 */
public class Leet169_MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElementInternal(nums, 0, nums.length - 1);
    }

    // Divide And Conquer
    private int majorityElementInternal(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return nums[start];
        }

        int mid = (start + end) >> 1;
        int leftMajority = majorityElementInternal(nums, start, mid);
        int rightMajority = majorityElementInternal(nums, mid + 1, end);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int lcount = 0, rcount = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == leftMajority) {
                lcount++;
            } else if (nums[i] == rightMajority) {
                rcount++;
            }
        }

        return lcount > rcount ? leftMajority : rightMajority;
    }
}
