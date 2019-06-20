package com.zjl.leetcode;

/**
 * @author zjl
 * @date 2019-06-20
 */
public class Leet70_ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        int wayPre = 2, wayPrePre = 1, wayCurrent = 3;

        for (int i = 3; i <= n; i++) {
            wayCurrent = wayPre + wayPrePre;
            wayPrePre = wayPre;
            wayPre = wayCurrent;
        }

        return wayCurrent;
    }

}
