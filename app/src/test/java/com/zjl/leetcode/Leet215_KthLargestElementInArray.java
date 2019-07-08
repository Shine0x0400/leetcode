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
}
