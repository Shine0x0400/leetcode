package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-26
 */
public class Leet11_ContainerWithMostWater {


    // using Two Pointers
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int max = 0, s = 0, e = height.length - 1;
        while (s < e) {
            max = Math.max(max, Math.min(height[s], height[e]) * (e - s));

            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }

        return max;
    }

//    // using Brute Force
//    public int maxArea(int[] height) {
//        if (height.length < 2) {
//            return 0;
//        }
//
//        int max = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
//            }
//        }
//
//        return max;
//    }
}
