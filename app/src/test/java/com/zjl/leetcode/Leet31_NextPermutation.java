package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-27
 */
public class Leet31_NextPermutation {

    public void nextPermutation(int[] nums) {

        int i = nums.length - 1;
        // find i, where nums[i] is bigger than its previous
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (i >= 1) {// found
            int change = nums[i - 1];

            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] <= change) {
                    break;
                }
            }

            // j-1位置的是大于change的最小值
            nums[i - 1] = nums[j - 1];
            nums[j - 1] = change;
        }

        // sort [i, length-1]
        if (i >= 0) {
//            Arrays.sort(nums, i, nums.length);
            int j = nums.length - 1;
            while (i < j) {
                // swap i j
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

    }
}
