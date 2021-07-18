package com.zjl.leetcode;

/**
 * @author dylannzhang
 * @date 7/18/21
 */
public class Leet4_MedianOfTwoSortedArrays {
    // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1.length < nums2.length ? nums1 : nums2; // short one
        int[] b = nums1.length < nums2.length ? nums2 : nums1; // long one

        int l = 0, r = a.length;

        return binarySearch(l, r, a, b);
    }

    private double binarySearch(int l, int r, int[] a, int[] b) {
        int i = (l + r) / 2; // a左半部分个数
        int j = (a.length + b.length + 1) / 2 - i; //b左半部分个数，奇数时，左半部分多1

        if (i > 0 && a[i - 1] > b[j]) { // a[i] too big
            return binarySearch(l, i - 1, a, b);
        } else if (i < a.length && a[i] < b[j - 1]) { // a[i] < b[j - 1], a[i] too small
            return binarySearch(i + 1, r, a, b);
        }

        // (a[i - 1] <= b[j] && a[i] >= b[j - 1])
        int maxOfLeft;
        if (i == 0) {
            maxOfLeft = b[j - 1];
        } else if (j == 0) {
            maxOfLeft = a[i - 1];
        } else {
            maxOfLeft = Math.max(a[i - 1], b[j - 1]);
        }

        int sum = a.length + b.length;
        if (sum % 2 == 1) {
            return maxOfLeft;
        }

        int minOfRight;
        if (i == a.length) {
            minOfRight = b[j];
        } else if (j == b.length) {
            minOfRight = a[i];
        } else {
            minOfRight = Math.min(a[i], b[j]);
        }

        return (maxOfLeft + minOfRight) / 2d;
    }
}
