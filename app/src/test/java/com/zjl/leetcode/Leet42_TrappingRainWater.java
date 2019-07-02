package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-07-01
 */
public class Leet42_TrappingRainWater {

    // using Two Pointers
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int level = 0;// 水位
        int capacity = 0;

        while (l <= r) {
            while (l <= r && height[l] <= level) {
                capacity -= Math.min(level, height[l]);
                l++;
            }

            while (l <= r && height[r] <= level) {
                capacity -= Math.min(level, height[r]);
                r--;
            }

            if (l <= r) {
                int levelHigh = Math.min(height[l], height[r]);
                capacity += (r - l + 1) * (levelHigh - level);
                level = levelHigh;
            }

        }

        return capacity;
    }
}
