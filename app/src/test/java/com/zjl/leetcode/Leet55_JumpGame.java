package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-29
 */
public class Leet55_JumpGame {

    // using DP
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        boolean[] jump = new boolean[nums.length];
        jump[jump.length - 1] = true;

        for (int i = jump.length - 2; i >= 0; i--) {
            jump[i] = false;

            int step = nums[i];
            if (step >= jump.length - 1 - i) {
                jump[i] = true;
                continue;
            }

            for (int j = 1; j <= step; j++) {
                if (jump[i + j]) {
                    jump[i] = true;
                    break;
                }
            }
        }

        return jump[0];
    }
}
