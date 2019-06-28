package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet75_SortColors {

    public void sortColors(int[] nums) {

        int s = 0, e = nums.length - 1;

        while (s < e && nums[s] == 0) {
            s++;
        }

        while ((s < e && nums[e] == 2)) {
            e--;
        }

        int i = s;
        while (i <= e) {
            if (nums[i] == 0) {
                nums[i] = nums[s];
                nums[s++] = 0;
                while (s < e && nums[s] == 0) {
                    s++;
                }
            } else if (nums[i] == 2) {
                nums[i] = nums[e];
                nums[e--] = 2;
                while ((s < e && nums[e] == 2)) {
                    e--;
                }
            } else {
                i++;
            }

            i = Math.max(s, i);
        }


    }
}
