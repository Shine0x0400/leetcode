package com.zjl.leetcode;

import java.util.PriorityQueue;

/**
 * @author zjl
 * @date 2019-07-08
 */
public class Leet215_KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        return queue.peek();
    }

    // 快排思想
    public int findKthLargestQuickSort(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        return quickSort(nums, i, j, k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        int i = start, j = end;
        int pivot = nums[i];
        while (i < j) {
            while (nums[j] < pivot && i < j) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] >= pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;

        if (i == k - 1) {
            return pivot;
        } else if (i > k - 1) {
            return quickSort(nums, start, i - 1, k);
        } else {
            return quickSort(nums, i + 1, end, k);
        }
    }
}
